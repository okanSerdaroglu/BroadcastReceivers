package com.example.stickybroadcastreceivers

import android.content.Intent
import android.content.IntentFilter
import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

/** stickyBroadcasts declare dynamically, however these
 *  type of receivers are deprecated because of security
 */

class MainActivity : AppCompatActivity() {

    private lateinit var batteryReceiver : BatteryReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun unregisterReceiverWithBroadcast(view: View) {

        /** when you register a stickyReceiver with receiver
         *  onReceive method works if user open the app
         */

        batteryReceiver = BatteryReceiver()
        val intentFilter = IntentFilter()
        registerReceiver(batteryReceiver,intentFilter)

    }

    fun registerReceiverWithoutBroadcast(view: View) {
        /** ACTION_BATTERY_CHANGED is a sticky broadcastReceiver
         *  This means that if your app is not using while this
         *  action send from phone, your app receives it when user clicks button
         */

        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED)
        val intent = registerReceiver(null, intentFilter)
        val batteryStatus = intent?.getIntExtra(BatteryManager.EXTRA_STATUS,-1)
        Utils.showBatteryStatus(batteryStatus!!)


    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(batteryReceiver)
    }
}
