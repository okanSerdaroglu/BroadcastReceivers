package com.example.orderedbroadcastreceivers

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    /** priority added in android manifest for the same action name
     *  broadCastReceivers. If you don't add this priority to broadcastReceivers,
     *  they work according to their queue in androidManifest
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendBroadcast(view: View) {
        val intent = Intent("custom_name")
        val bundle = Bundle()
        bundle.putString("name", "main")
        /** forthReceiver declared as a result receiver */
        sendOrderedBroadcast(
            intent, null,
            ForthReceiver(), null, Activity.RESULT_OK, null, bundle
        )
    }


    class SecondReceiver : BroadcastReceiver() {

        private var tag = SecondReceiver::class.java.simpleName

        override fun onReceive(context: Context?, intent: Intent?) {
            if (isOrderedBroadcast) {
                /** these methods for special for orderedBroadcastReceivers*/
                val code = resultCode
                val data = resultData
                val bundle = getResultExtras(true)
                val name = bundle.getString("name")
                Log.i(tag, "code $code, data $data, name $name")

                resultCode = 2
                resultData = "iki"
                bundle.putString("name", "iki")

                /** this method stops the broadcasting */
                abortBroadcast()

            }


            Toast.makeText(context, tag, Toast.LENGTH_LONG).show()
        }

    }


}
