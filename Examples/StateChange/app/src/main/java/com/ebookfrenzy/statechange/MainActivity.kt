package com.ebookfrenzy.statechange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ebookfrenzy.statechange.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val tAG = "StateChange"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i(tAG, "onCreate")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(tAG, "onRestoreInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Log.i(tAG, "onStart")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(tAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(tAG, "onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(tAG, "onSaveInstanceState")
    }

    override fun onPause() {
        super.onPause()
        Log.i(tAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(tAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(tAG, "onDestroy")
    }
}