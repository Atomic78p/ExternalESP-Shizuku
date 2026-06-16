package com.example.externalesp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ShizukuHelper.init(this)

        // Start overlay
        val intent = Intent(this, OverlayService::class.java)
        startService(intent)
    }
} 