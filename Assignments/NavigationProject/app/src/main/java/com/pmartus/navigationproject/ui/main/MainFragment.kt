package com.pmartus.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.pmartus.navigationproject.databinding.FragmentMainBinding
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
            buttonPress(it,1, "android_image_1")
        }
        binding.button2.setOnClickListener{ it ->
            buttonPress(it, 2, "android_image_2")
        }
        binding.button3.setOnClickListener{ it ->
            buttonPress(it, 3, "android_image_3")
        }
    }

    fun buttonPress(view: View, num: Int, imageID: String) {
        val action : MainFragmentDirections.MainToSecond = MainFragmentDirections.mainToSecond()
        action.imageID =  imageID
        action.title = "Image $num"
        Navigation.findNavController(view).navigate(action)
    }

}