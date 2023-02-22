package com.pmartus.addnamesavedata.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var nameBox: MutableLiveData<String> = MutableLiveData()
    var list: MutableList<String> = mutableListOf<String>()
    var namesList: MutableLiveData<String> = MutableLiveData("")

    fun addName() {
        nameBox.let {
            if (!it.value.equals("")) {
                list.add(it.value.toString())
                for (n: String in list) {
                    namesList.value += n + "\n"
                }
            }


        }


    }
}