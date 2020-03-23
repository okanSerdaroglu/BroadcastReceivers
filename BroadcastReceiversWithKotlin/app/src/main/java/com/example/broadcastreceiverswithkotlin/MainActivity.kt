package com.example.broadcastreceiverswithkotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

/** in android system messages go from operating system to android apps.
 *  if your app listen to this messages you can do what ever you want as
 *  a result of this receiver, in onReceive method.
 */

/** if receiver's action names are the same, receivers work according to their
 *  queue in android manifest.
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendBroadcastFirstReceiver(view: View) {
        val intent = Intent(this, FirstReceiver::class.java) // directly name
        intent.putExtra("name","okan")
        intent.putExtra("age",32)
        sendBroadcast(intent)
        /** you can call broadcastReceivers two different ways.
         *  directly name
         *  with action name
         */
    }

    fun sendBroadcastSecondReceiver(view: View) {
        val intent = Intent("second.custom.action") // action name
        sendBroadcast(intent)
        /** action name must be the same in android manifest **/
    }

    class SecondReceiver : BroadcastReceiver() {

        companion object {
            private val TAG = SecondReceiver::class.java.simpleName
        }

        override fun onReceive(context: Context?, intent: Intent?) {
            Log.i(TAG, "from second receiver")
            Toast.makeText(context, TAG, Toast.LENGTH_LONG).show()
        }

    }

}
