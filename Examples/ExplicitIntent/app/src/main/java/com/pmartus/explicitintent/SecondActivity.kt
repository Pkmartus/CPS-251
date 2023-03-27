package com.pmartus.explicitintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import com.pmartus.explicitintent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //unpack the extras from the intent if any exist
        val extras = intent.extras ?:return
        //use the key to extract the value of the string
        val qString = extras.getString("qString")
        binding.textView2.text = qString
    }
    //the returnText method bound to button two calls the finish method below
    fun returnText(view: View) {
        finish()
    }

    override fun finish() {
        //create new intent to take us back to the first activity
        val data = Intent()
        //add the text from the text box to the bundle as a key-value pair
        val returnString = binding.editText2.text.toString()
        data.putExtra("returnData", returnString)
        setResult(RESULT_OK, data)
        super.finish()
    }

}