package com.example.broadcastreceiverswithkotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class FirstReceiver : BroadcastReceiver() {

    companion object{
        private val TAG = FirstReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context?, intent: Intent?) {
       Log.i(TAG,"from first receiver")
       Toast.makeText(context,TAG,Toast.LENGTH_LONG).show()
    }

}