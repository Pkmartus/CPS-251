package com.pmartus.recycleviewintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pmartus.recycleviewintent.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val extras = intent.extras ?:return
        val position = extras.getInt("position")
        binding.title2.text = Data.getTitle(position)
        binding.data.text = Data.getDetails(position)
        binding.imageView2.setImageResource(Data.getImages(position))
    }
}