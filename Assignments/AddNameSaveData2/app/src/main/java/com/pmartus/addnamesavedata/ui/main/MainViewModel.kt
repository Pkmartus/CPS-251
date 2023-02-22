package com.pmartus.addnamesavedata.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var nameBox = ""
    private var namesList = ""

    fun addName(value: String) {
        this.nameBox = value
        this.namesList = this.namesList + "\n" + this.nameBox
    }

    fun getNamesList(): String {
        return namesList
    }
}