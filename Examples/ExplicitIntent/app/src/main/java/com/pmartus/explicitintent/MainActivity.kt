package com.pmartus.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pmartus.explicitintent.databinding.ActivityMainBinding
import android.view.View
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import android.app.Activity
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //create a request code for the intent
    //part of old depreciated method no longer necessary
    //private val request_code = 5

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
        //start the activity with a simple intent one way street
        //startActivity(i)
        //start activity as a sub activity using the request code old version
        //startActivityForResult(i, request_code)
    //new method
        startForResult.launch(i)
    }
    //new way to send intent with a result
    val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
        result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            data?.let {
                if (it.hasExtra("returnData")) {
                    val returnString = it.extras?.getString("returnData")
                    binding.textView1.text = returnString
                }
            }
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        //check if request code matches the one given by the intent and ensure activity is sucessful
//        if((requestCode == request_code)&&(resultCode == RESULT_OK)){
//            data?.let {
//                if (it.hasExtra("returnData")) {
//                    val returnString = it.extras?.getString("returnData")
//                    binding.textView1.text = returnString
//                }
//            }
//        }
//    }
}