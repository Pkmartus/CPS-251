package com.pmartus.roomdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pmartus.roomdemo.R
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmartus.roomdemo.Product
import androidx.fragment.app.viewModels
import java.util.*
import com.pmartus.roomdemo.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private var adapter: ProductListAdapter? = null
    val viewModel: MainViewModel by viewModels()
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

   /* override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }*/

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
        binding.addButton.setOnClickListener() {
            val name = binding.productName.text.toString()
            val quantity = binding.productQuantity.text.toString()
            if (name != "" && quantity != "") {
                val product = Product(name, Integer.parseInt(quantity))
                viewModel.insertProduct(product)
                clearFields()
            } else {
                binding.productID.text = "Incomplete Information"
            }
        }
        binding.findButton.setOnClickListener{
            viewModel.findProduct(binding.productName.text.toString()) }
        binding.deleteButton.setOnClickListener{
            viewModel.deleteProduct(binding.productName.text.toString())
            clearFields()
        }
    }

    private fun observerSetup() {
        viewModel.getAllProducts()?.observe(viewLifecycleOwner,
            Observer { products -> products?.let {
                adapter?.setProductList(it)
            } })
        viewModel.getSearchResults().observe(viewLifecycleOwner,
            Observer { products ->  products?.let {
                if (it.isNotEmpty()) {
                    binding.productID.text = String.format(Locale.US, "%d" , it[0].id)
                    binding.productName.setText(it[0].productName)
                    binding.productQuantity.setText(String.format(Locale.US, "%d", it[0].quantity))
                } else {
                    binding.productID.text = "No Match"
                }
            }})
    }

    private fun recyclerSetup() {
        adapter = ProductListAdapter(R.layout.product_list_item)
        binding.productRecycler.layoutManager = LinearLayoutManager(context)
        binding.productRecycler.adapter = adapter
    }

    private fun clearFields() {
        binding.productID.text = ""
        binding.productName.setText("")
        binding.productQuantity.setText("")
    }




}