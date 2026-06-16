package com.example.externalesp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class ESPView(context: Context) : View(context) {
    private val paint = Paint().apply {
        color = Color.RED
        strokeWidth = 8f
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // Test box
        canvas.drawRect(300f, 300f, 700f, 900f, paint)
        // TODO: Real ESP drawing from memory data
    }
} 