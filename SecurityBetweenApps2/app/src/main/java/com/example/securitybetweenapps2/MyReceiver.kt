package com.example.securitybetweenapps2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

/** MyReceiver receives message from the same action name
 *  intent, from other apps. Because it is declared in
 *  AndroidManifest and exported true. If you declare
 *  exported parameter false MyReceiver does not get
 *  message from other apps wiht this action name
 */

class MyReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "received from second App", Toast.LENGTH_LONG).show()
    }
}