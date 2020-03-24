package com.example.orderedbroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class ForthReceiver : BroadcastReceiver() {

    companion object{
        private var TAG = ForthReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context?, intent: Intent?) {

        val code = resultCode
        val data = resultData
        val bundle = getResultExtras(true)
        val name = bundle.getString("name")
        Log.i(TAG, "code $code, data $data, name $name")

    }

}