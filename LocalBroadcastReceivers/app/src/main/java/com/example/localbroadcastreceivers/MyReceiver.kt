package com.example.localbroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MyReceiver : BroadcastReceiver() {

    /** firstly numberOne and numberTwo send from activity
     *  then values read in the receiver. After that a manager
     *  declared and result send back mainActivity from this receiver
     */

    override fun onReceive(context: Context?, intent: Intent?) {

        val numberOne = intent?.getIntExtra("numberOne", 0)
        val numberTwo = intent?.getIntExtra("numberTwo", 0)
        val sum = numberOne?.plus(numberTwo!!)

        val manager = LocalBroadcastManager.getInstance(context!!)
        val intentResult = Intent(context.getString(R.string.result_receiver))
        intentResult.putExtra("sum", sum)
        manager.sendBroadcast(intentResult)

    }



}