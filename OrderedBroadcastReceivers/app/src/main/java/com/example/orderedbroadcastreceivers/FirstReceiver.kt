package com.example.orderedbroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class FirstReceiver : BroadcastReceiver() {

    companion object{
        private final var TAG = FirstReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG,"from first receiver")
        Toast.makeText(context, TAG, Toast.LENGTH_LONG).show()
    }
}