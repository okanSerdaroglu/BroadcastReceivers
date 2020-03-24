package com.example.orderedbroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class ThirdReceiver : BroadcastReceiver() {

    companion object {
        private val TAG = ThirdReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG, "from third receiver")
        Toast.makeText(context, TAG, Toast.LENGTH_LONG).show()
    }
}