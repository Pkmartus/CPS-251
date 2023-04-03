package com.pmartus.sendbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    //handle reception of broadcast
    override fun onReceive(context: Context, intent: Intent) {
        val message = "Broadcast intent detected" + intent.action
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}