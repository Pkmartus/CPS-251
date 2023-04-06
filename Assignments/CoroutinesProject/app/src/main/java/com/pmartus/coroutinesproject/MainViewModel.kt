package com.pmartus.coroutinesproject

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var outputs = mutableListOf<String>()

    fun addOutput(name: String, time: Int) {
        outputs.add("The name is $name and the delay was $time milliseconds")
        Log.i("ZZZ", "add output")
    }

}
