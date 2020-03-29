package com.example.securitybetweenapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

/** permission name and protectionLevel as signature
 *  in AndroidManifest. Signature means this permission name
 *  must be the same with second app
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendMessage(view: View) {

        val intent = Intent("action.name")
        sendBroadcast(intent)

    }
}
