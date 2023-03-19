package com.pmartus.navigationproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.net.Uri
import com.pmartus.navigationproject.ui.main.SecondFragment

class MainActivity : AppCompatActivity(),SecondFragment.onFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onFragmentInteraction(uri: Uri){

    }
}