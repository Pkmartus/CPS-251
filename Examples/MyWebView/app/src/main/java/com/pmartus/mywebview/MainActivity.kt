package com.pmartus.mywebview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pmartus.mywebview.databinding.ActivityMainBinding
import java.net.URL

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleIntent()
    }

    private fun handleIntent() {
        //obtains reference to the intent which caused the activity to be launched
        val intent = this.intent
        //extracts uri data from intent object
        val data = intent.data
        var url: URL? = null
        //loads url into the webview converting it to a string in the process
        try {
            url = URL(data?.scheme, data?.host, data?.path)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        binding.webView1.loadUrl(url.toString())
    }
}