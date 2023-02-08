package com.ebookfrenzy.eventexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.eventexample.databinding.ActivityMainBinding
import android.view.View


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

//when the button is pressed the text above is changed
        binding.myButton.setOnClickListener{
            binding.statusText.text = getString(R.string.clicked)
        }
        //adding a long click method
        binding.myButton.setOnLongClickListener {
            "Long Button Click".also { binding.statusText.text = it }
            true
        }


    }
}