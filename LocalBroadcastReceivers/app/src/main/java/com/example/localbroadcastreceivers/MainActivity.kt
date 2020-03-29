package com.example.localbroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.localbroadcastmanager.content.LocalBroadcastManager

class MainActivity : AppCompatActivity() {

    lateinit var localBroadcastManager : LocalBroadcastManager
    lateinit var resultReceiver: ResultReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        localBroadcastManager = LocalBroadcastManager.getInstance(this)
        resultReceiver = ResultReceiver()
    }

    override fun onResume() {
        super.onResume()
        val intentFilter=IntentFilter()
        intentFilter.addAction(this.getString(R.string.result_receiver))
        localBroadcastManager.registerReceiver(resultReceiver,intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(resultReceiver)
    }

    fun sendMessage(view: View) {

        val intent = Intent(this, MyReceiver::class.java)
        intent.putExtra("numberOne", 10)
        intent.putExtra("numberTwo", 5)
        sendBroadcast(intent)
    }

    open class ResultReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            val sum = intent?.getIntExtra("sum",0)
            Toast.makeText(context,sum.toString(),Toast.LENGTH_LONG).show()
        }
    }

}
