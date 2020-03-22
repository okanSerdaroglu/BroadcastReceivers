package com.example.broadcastreceiverswithkotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendBroadcastFirstReceiver(view: View) {
        val intent = Intent(this, FirstReceiver::class.java)
        sendBroadcast(intent)
    }

    fun sendBroadcastSecondReceiver(view: View) {
        val intent = Intent(this,SecondReceiver::class.java)
        sendBroadcast(intent)
    }

    class SecondReceiver : BroadcastReceiver() {

        companion object {
            private val TAG = SecondReceiver::class.java.simpleName
        }

        override fun onReceive(context: Context?, intent: Intent?) {
            Log.i(TAG,"from second receiver")
            Toast.makeText(context, TAG, Toast.LENGTH_LONG).show()
        }

    }


}
