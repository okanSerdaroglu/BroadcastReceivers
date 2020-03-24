package com.example.orderedbroadcastreceivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class ThirdReceiver : BroadcastReceiver() {

    /** this is declared as result receiver in mainActivity
     * for this reason broadcasting stops here
     */

    companion object {
        private val TAG = ThirdReceiver::class.java.simpleName
    }

    override fun onReceive(context: Context?, intent: Intent?) {

        if (isOrderedBroadcast){
            /** these methods for special for orderedBroadcastReceivers*/
           val code = resultCode
           val data = resultData
           val bundle = getResultExtras(true)
           val name = bundle.getString("name")
           Log.i(TAG, "code $code, data $data, name $name")

           resultCode = 3
           resultData = "uc"
           bundle.putString("name","uc")

        }


        Toast.makeText(context, TAG, Toast.LENGTH_LONG).show()
    }
}