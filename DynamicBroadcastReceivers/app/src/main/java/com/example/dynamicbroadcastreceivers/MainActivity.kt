package com.example.dynamicbroadcastreceivers

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

/** you have to register dynamic receivers in onResume()
 *  and you have to unregister them in onPause(). if you
 *  don't unregister the dynamic receiver user goes on
 *  app normally however in LogCat you will see an error
 *  which call 'leak IntentReceiver'
 */

class MainActivity : AppCompatActivity() {

    private lateinit var firstReceiver : FirstReceiver
    private lateinit var timeTickReceiver: TimeTickReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firstReceiver = FirstReceiver()
        timeTickReceiver = TimeTickReceiver()
    }

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(firstReceiver,intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(firstReceiver)
    }

    fun registerReceiver(view: View) {
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_TIME_TICK)
        registerReceiver(timeTickReceiver,intentFilter)
    }

    fun unregisterReceiver(view: View) {
        unregisterReceiver(timeTickReceiver)
    }
}
