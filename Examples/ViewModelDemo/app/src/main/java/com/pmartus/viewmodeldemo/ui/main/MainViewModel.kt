package com.pmartus.viewmodeldemo.ui.main

import androidx.lifecycle.ViewModel
import java.time.OffsetDateTime

class MainViewModel : ViewModel() {

    private val rate = 0.74f
    private var dollarText = ""
    private var result: Float = 0f

    fun setAmount(value: String) {
        this.dollarText = value
        result = value.toFloat()*rate
    }

    fun getResult(): Float {
        return result
    }
}