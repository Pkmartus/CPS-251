package com.pmartus.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pmartus.viewmodeldemo.databinding.FragmentMainBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.get

class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private  val binding get() = _binding!!

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

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

        activity?.application.let {
            val factory = SavedStateViewModelFactory(it, this)
            viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
            val resultObserver = Observer<Float> { result -> binding.resultText.text = result.toString()  }
            viewModel.getResult().observe(viewLifecycleOwner, resultObserver)

            binding.convertButton.setOnClickListener{
                if (binding.dolarText.text.isNotEmpty()){
                    viewModel.setAmount(binding.dolarText.text.toString())
                } else {
                    binding.resultText.text = "No Value"
                }
            }
        }
    }
}