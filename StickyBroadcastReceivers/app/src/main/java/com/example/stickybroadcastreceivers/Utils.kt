package com.example.stickybroadcastreceivers

import android.util.Log

class Utils {
    companion object {
        fun showBatteryStatus(batteryStatus: Int) {
            when (batteryStatus) {
                1 -> {
                    Log.i("Status : ", "Unknown Status")
                }
                2 -> {
                    Log.i("Status : ", "Charging")
                }
                3 -> {
                    Log.i("Status : ", "Not Charging")
                }
                4 -> {
                    Log.i("Status : ", "Removed From Charge")
                }
                5 -> {
                    Log.i("Status : ", "Full Battery")

                }
                -1 -> {
                    Log.i("Status : ", "Unknown Status")
                }
            }
        }
    }
}