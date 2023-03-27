package com.pmartus.implicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.net.Uri

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showWebPage(view: View) {
        //create an implicit intent which will cause the system to search for an app registered to do that action
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ebookfrenzy.com"))
        startActivity(intent)
    }
}