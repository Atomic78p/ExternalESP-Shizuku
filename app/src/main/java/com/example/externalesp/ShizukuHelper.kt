package com.example.externalesp

import android.content.Context
import android.content.pm.PackageManager
import rikka.shizuku.Shizuku

object ShizukuHelper {
    private const val REQUEST_CODE = 1001

    fun init(context: Context) {
        Shizuku.addBinderReceivedListener {
            checkAndRequestPermission(context)
        }
        Shizuku.addRequestPermissionResultListener { requestCode, grantResult ->
            if (requestCode == REQUEST_CODE && grantResult == PackageManager.PERMISSION_GRANTED) {
                // Permission granted
            }
        }
    }

    private fun checkAndRequestPermission(context: Context) {
        if (Shizuku.checkSelfPermission() == PackageManager.PERMISSION_GRANTED) {
            // Ready
        } else {
            Shizuku.requestPermission(REQUEST_CODE)
        }
    }
} 