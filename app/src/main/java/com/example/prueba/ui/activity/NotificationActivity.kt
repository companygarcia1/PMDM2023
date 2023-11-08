package com.example.prueba.ui.activity

import android.Manifest
import android.app.Activity
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationManagerCompat
import com.example.prueba.R
import com.example.prueba.databinding.ActivityNotificationBinding
import com.example.prueba.databinding.ActivityThreadBinding
import com.example.prueba.utils.NotificationManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class NotificationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNotificationBinding
    private var NOTIFICATION_REQUEST_CODE=1234
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
        setConfigView()
    }

    private fun setConfigView() {
    }

    private fun setListener() {
        binding.btnBasica.setOnClickListener {
            val builder = NotificationManager.buildNotification(this, "mi_canal")
            builder.setContentText("Prueba notificacion")
            builder.setContentTitle("Esto es una descripcion de notificacion")
            builder.setSmallIcon(R.drawable.ic_launcher_foreground)
            NotificationManager.show(this, NOTIFICATION_REQUEST_CODE, builder)
        }

        binding.btnIntent.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)

            val builder = NotificationManager.buildNotification(this, "mi_canal")
            builder.setContentText("Prueba notificacion")
            builder.setContentTitle("Esto es una descripcion de notificacion")
            builder.setSmallIcon(R.drawable.ic_launcher_foreground)
            builder.setContentIntent(pendingIntent)
            builder.setAutoCancel(true)
            NotificationManager.show(this, NOTIFICATION_REQUEST_CODE, builder)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == NOTIFICATION_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val builder = NotificationManager.buildNotification(this, "mi_canal")
                builder.setContentText("Prueba notificacion")
                builder.setContentTitle("Esto es una descripcion de notificacion")
                builder.setSmallIcon(R.drawable.ic_launcher_foreground)
                NotificationManager.show(this, 1234, builder)
            }
            if (resultCode == Activity.RESULT_CANCELED) {

            }
        }
    }

}