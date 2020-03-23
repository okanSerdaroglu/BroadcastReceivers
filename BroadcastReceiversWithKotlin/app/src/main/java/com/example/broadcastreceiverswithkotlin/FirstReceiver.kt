package com.example.broadcastreceiverswithkotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

/** types of broadCastReceivers
 *  normal
 *  ordered
 *  sticky
 *  local
 */

class FirstReceiver : BroadcastReceiver() {

    /** broadCastReceivers work on UI thread
     *  for this reason you don't have to work 10000
     *  ms longer jobs in this thread. If you try it
     *  you are going to get ANR ( application not responding ) error
     */

    companion object {
        private val TAG = FirstReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Log.i(TAG, "from first receiver : " + Thread.currentThread().name)
        Toast.makeText(context, TAG, Toast.LENGTH_LONG).show()
        val name = intent?.getStringExtra("name")
        val age = intent?.getIntExtra("age", 0)

        Log.i("intent data", "name $name , age $age")

        //Thread.sleep(15000) // this is a job which is longer than 10000 ms

    }

}