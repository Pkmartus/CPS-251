package com.pmartus.coroutinedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pmartus.coroutinedemo.databinding.ActivityMainBinding
import android.widget.SeekBar
import kotlinx.coroutines.*
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //counter for seekbar
    private var count: Int = 1
    //declaring the scope of the coroutines
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting up listener for seekbar that will change the count variable when the bar is moved and display it on the text view
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seek: SeekBar?, progress: Int, fromUser: Boolean) {
                count = progress
                binding.countText.text = "${count} coroutines"
            }
            //implemented methods that are required but not needed for this program
            override fun onStartTrackingTouch(seek: SeekBar?) {

            }
            override fun onStopTrackingTouch(p0: SeekBar?) {

            } })
    }

    //implementing the launchCoroutines method expected by the button
    fun launchCoroutines(view: View) {
        //loop through the number of times is selected by the seekbar
        (1..count).forEach{
            binding.statusText.text = "Started Coroutine ${it}"
            //start a coroutine and display its return on the second text view
            coroutineScope.launch(Dispatchers.Main) {
                binding.statusText.text = preformTask(it).await()
            }
        }
    }

    //creating a suspend function to launch coroutines
    suspend fun preformTask(tasknumber: Int): Deferred<String> = coroutineScope.async(Dispatchers.Main) {
        //add a 5 second delay to the coroutine
        delay(5_000)
        return@async "Finished Coroutine ${tasknumber}"
    }
}