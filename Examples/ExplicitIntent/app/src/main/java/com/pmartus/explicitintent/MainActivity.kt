package com.pmartus.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pmartus.explicitintent.databinding.ActivityMainBinding
import android.view.View
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //create a request code for the intent
    private val request_code = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
//send text method creates an intent between this and the second activity
    fun sendText(view: View) {
        val i = Intent(this, SecondActivity::class.java)
    //pull the value from the edit text box and create a key-value pair to pass through thin intent.
        val myString = binding.editText1.text.toString()
        i.putExtra("qString", myString)
        //start the activity with a simple intent
        //startActivity(i)
        //start activity as a sub activity using the request code
        startActivityForResult(i, request_code)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //check if request code matches the one given by the intent and ensure activity is sucessful
        if((requestCode == request_code)&&(resultCode == RESULT_OK)){
            data?.let {
                if (it.hasExtra("returnData")) {
                    val returnString = it.extras?.getString("returnData")
                    binding.textView1.text = returnString
                }
            }
        }
    }
}