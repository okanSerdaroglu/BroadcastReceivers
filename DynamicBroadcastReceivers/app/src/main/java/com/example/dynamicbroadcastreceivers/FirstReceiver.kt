package com.example.dynamicbroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

/** dynamic receivers works only when user use the app
 *  If you declare your receivers in android manifest
 *  your receiver exactly works. However in this you
 *  can control if your app using while this change happen
 *  in the mobile device
 */

class FirstReceiver : BroadcastReceiver() {

    companion object {
        private final var TAG = FirstReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "First Receiver", Toast.LENGTH_LONG).show()
        Log.i(TAG, "First Receiver")
    }
}