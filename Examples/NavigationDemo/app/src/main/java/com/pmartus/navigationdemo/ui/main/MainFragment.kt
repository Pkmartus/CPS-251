package com.pmartus.navigationdemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pmartus.navigationdemo.R
import com.pmartus.navigationdemo.databinding.FragmentMainBinding
import androidx.navigation.Navigation

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.button.setOnClickListener{ it ->
            val action : MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()
            action.message = binding.userText.text.toString()
            Navigation.findNavController(it).navigate(action)
        }
    }

}