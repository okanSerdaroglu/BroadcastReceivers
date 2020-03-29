package com.example.localbroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val numberOne = intent?.getIntExtra("numberOne",0)
        val numberTwo = intent?.getIntExtra("numberTwo",0)
        val sum = numberOne?.plus(numberTwo!!)
        Toast.makeText(context,sum.toString(),Toast.LENGTH_LONG).show()

    }

}