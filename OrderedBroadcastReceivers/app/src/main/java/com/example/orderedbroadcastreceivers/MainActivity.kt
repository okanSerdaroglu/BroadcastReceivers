package com.example.orderedbroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendBroadcast(view: View) {
        val intent = Intent("custom_name")
        sendOrderedBroadcast(intent,null)
    }


    class SecondReceiver : BroadcastReceiver(){

        private var tag = SecondReceiver::class.java.simpleName

        override fun onReceive(context: Context?, intent: Intent?) {
            Log.i(tag,"from second receiver")
            Toast.makeText(context, tag,Toast.LENGTH_LONG).show()
        }

    }


}
