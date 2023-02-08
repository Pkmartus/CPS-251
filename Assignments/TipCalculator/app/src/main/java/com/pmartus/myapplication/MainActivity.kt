package com.pmartus.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pmartus.myapplication.databinding.ActivityMainBinding
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcButton.setOnClickListener {
            calculateTip()
        }
    }

    fun calculateTip() {
        if (binding.enterBill.text.isNotEmpty()) {
            val bill = binding.enterBill.text.toString().toFloat()
            val twenty = ((bill * 1.2)*100.0).roundToInt() /100.0
            val eighteen = ((bill * 1.18)*100.0).roundToInt() /100.0
            val fifteen = ((bill * 1.15)*100.0).roundToInt() /100.0
            binding.results.text =
                "The tips are as follows \n \n 20% = $twenty\n 18% = $eighteen\n 15% = $fifteen"
        } else {
            binding.results.text = "YOU MUST ENTER A BILL AMOUNT"
        }
    }

}
