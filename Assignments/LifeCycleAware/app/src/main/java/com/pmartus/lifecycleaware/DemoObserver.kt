package com.pmartus.lifecycleaware

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.pmartus.lifecycleaware.ui.main.MainViewModel

class DemoObserver: DefaultLifecycleObserver {

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        MainViewModel.addOutput("onResume", true)
    }

    override fun onPause(owner: LifecycleOwner) {
        super.onPause(owner)
        MainViewModel.addOutput("onPause", true)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        super.onDestroy(owner)
        MainViewModel.addOutput("onDestroy", true)
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onResume(owner)
        MainViewModel.addOutput("onCreate", false)
    }

    override fun onStart(owner: LifecycleOwner) {
        super.onStart(owner)
        MainViewModel.addOutput("onStart", false)
    }

    override fun onStop(owner: LifecycleOwner) {
        super.onStop(owner)
        MainViewModel.addOutput("onStop", true)
    }
}