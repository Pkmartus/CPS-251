package com.pmartus.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pmartus.viewmodeldemo.databinding.FragmentMainBinding
import androidx.lifecycle.Observer

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private  val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //return inflater.inflate(R.layout.fragment_main, container, false)
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.resultText.text = viewModel.getResult().toString()
        //the next 2 lines add the observer to the method
        val resultObserver = Observer<Float> { result -> binding.resultText.text = result.toString()  }
        viewModel.getResult().observe(viewLifecycleOwner, resultObserver)

        binding.convertButton.setOnClickListener{
            if (binding.dolarText.text.isNotEmpty()){
                viewModel.setAmount(binding.dolarText.text.toString())
                //binding.resultText.text = viewModel.getResult().toString()
            } else {
                binding.resultText.text = "No Value"
            }
        }
    }

}