package com.example.prueba.utils

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

object PermissionManager {
    // Método para verificar si el permiso de notificaciones está otorgado
    fun isNotificationPermissionGranted(activity: Activity, permissions: String): Boolean {
        return ContextCompat.checkSelfPermission(
            activity,
            permissions
        ) == PackageManager.PERMISSION_GRANTED
    }

    fun requestPermission(
        activity: Activity,
        permission: String,
        requestCode: Int
    ): Boolean {
        // Verificar si el permiso ya está otorgado
        if (isNotificationPermissionGranted(activity, permission)) {
            return true
        } else {
            // El permiso no está otorgado, solicitarlo al usuario
            ActivityCompat.requestPermissions(
                activity,
                arrayOf(permission),
                requestCode
            )
            return false
        }
    }
}