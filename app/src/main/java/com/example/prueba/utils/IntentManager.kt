package com.example.prueba.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log

object IntentManager {

    fun OpenWeb(activity: Activity, url: String){
        val intent = Intent(
            Intent.ACTION_VIEW,
            Uri.parse(url)
        )

        if (intent.resolveActivity(activity.packageManager) != null) {
            activity.startActivity(intent)
        } else {
            Log.d("DEBUG", "Hay un problema para encontrar un navegador.")
        }
    }
}