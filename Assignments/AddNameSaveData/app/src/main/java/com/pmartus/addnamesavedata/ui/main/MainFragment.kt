package com.pmartus.addnamesavedata.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.get
import com.pmartus.addnamesavedata.R
import com.pmartus.addnamesavedata.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //todo check if this actually works or go back to get
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.namesListText.text = viewModel.getNamesList()

        binding.addNameButton.setOnClickListener{
            if (binding.nameBoxText.text.isNotEmpty()) {
                viewModel.addName(binding.nameBoxText.text.toString())
                binding.namesListText.text = viewModel.getNamesList()
            } else {
                binding.namesListText.text = "no Names"
            }
        }


    }


}