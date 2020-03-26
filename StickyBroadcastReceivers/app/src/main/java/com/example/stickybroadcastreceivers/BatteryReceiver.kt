package com.example.stickybroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager

class BatteryReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {

        val batteryStatus = intent?.getIntExtra(BatteryManager.EXTRA_STATUS,-1)
        Utils.showBatteryStatus(batteryStatus!!)

    }
}