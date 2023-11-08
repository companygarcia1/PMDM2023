package com.example.prueba.utils

import android.Manifest
import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.prueba.R

object NotificationManager {
    fun buildNotification(
        context: Context,
        canal: String,
    ): NotificationCompat.Builder {
        // Define un ID único para la notificación
        val notificationId = 1

        // Crea un canal de notificación si el dispositivo tiene Android 8.0 (Oreo) o superior
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = canal
            val channelName = "Mi Canal de Notificaciones"
            val description = "Descripción de Mi Canal de Notificaciones"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(channelId, channelName, importance).apply {
                this.description = description
            }

            val notificationManager = context.getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

        // Crea un objeto de notificación
        val builder = NotificationCompat.Builder(context, canal)
        return builder
    }


    fun show(activity: Activity, requestCode: Int, builder: NotificationCompat.Builder) {
        with(NotificationManagerCompat.from(activity)) {
            if (ActivityCompat.checkSelfPermission(
                    activity,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    PermissionManager.requestPermission(
                        activity,
                        Manifest.permission.POST_NOTIFICATIONS,
                        requestCode
                    )
                }
                return
            }
            notify(123, builder.build())
        }

    }
}