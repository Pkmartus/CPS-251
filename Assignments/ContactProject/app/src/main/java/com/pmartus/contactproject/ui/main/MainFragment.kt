package com.pmartus.contactproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmartus.contactproject.Contact
import androidx.fragment.app.viewModels
import com.pmartus.contactproject.databinding.FragmentMainBinding

class MainFragment : Fragment(), OnTrashClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var adapter: ContactListAdapter? = null
    val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding = FragmentMainBinding.inflate(inflater, container, false)
        //methods to setup the necessary steps for the recycler
        listenerSetup()
        observerSetup()
        recyclerSetup()
        return binding.root
    }

    private fun listenerSetup() {
        binding.addButton.setOnClickListener {
            val name = binding.contactName.text.toString()
            val number = binding.contactNumber.text.toString()
            if (name != "" && number.length == 10) {
                val contact = Contact(name, number)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                Toast.makeText(activity, "You must enter a name and Phone Number", Toast.LENGTH_SHORT).show()
            }
        }
        binding.findButton.setOnClickListener{
            viewModel.findContact(binding.contactName.text.toString()) }
        binding.ascButton.setOnClickListener{
            viewModel.sortContactAsc() }
        binding.descButton.setOnClickListener{
            viewModel.sortContactDesc() }
    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(viewLifecycleOwner
        ) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }
        viewModel.getSearchResults().observe(viewLifecycleOwner
        ) { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                } else {
                    Toast.makeText(activity, "You must enter a search criteria in the name field", Toast.LENGTH_SHORT).show()
                }
            }
        }
        viewModel.getSortedList().observe(viewLifecycleOwner)
        { contacts ->
            contacts?.let {
                if (it.isNotEmpty()) {
                    adapter?.setContactList(it)
                }
            }
        }
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(this)
        binding.contactRecycler.layoutManager = LinearLayoutManager(context)
        binding.contactRecycler.adapter = adapter
    }

    private fun clearFields() {
        binding.contactName.setText("")
        binding.contactNumber.setText("")
    }

    override fun onTrashClick(int: Int) {
        viewModel.deleteContact(int)
    }


}