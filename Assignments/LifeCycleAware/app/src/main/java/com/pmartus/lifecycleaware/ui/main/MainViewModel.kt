package com.pmartus.lifecycleaware.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalTime

class MainViewModel : ViewModel() {
//companion object contains data and methods needed to be accessed and maintained by both the observer and fragment
    companion object OutputData {
        var output: MutableLiveData<String> = MutableLiveData("")

        fun addOutput(string: String, endSet: Boolean) {
            output.value += string + " was fired at " + LocalTime.now() + "\n"
            if (endSet)
                output.value += "********* \n"
        }
    }
}
