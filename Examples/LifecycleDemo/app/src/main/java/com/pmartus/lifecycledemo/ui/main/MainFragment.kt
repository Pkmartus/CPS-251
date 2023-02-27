package com.pmartus.lifecycledemo.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pmartus.lifecycledemo.R
import com.pmartus.lifecycledemo.DemoObserver
import com.pmartus.lifecycledemo.DemoOwner

private lateinit var demoOwner: DemoOwner

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        demoOwner = DemoOwner()
        demoOwner.startOwner()
        demoOwner.stopOwner()
        //lifecycle.addObserver(DemoObserver())
    }

}