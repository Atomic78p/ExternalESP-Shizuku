package com.van4u.external

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
        textSize = 40f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Test Red Box
        canvas.drawRect(300f, 300f, 700f, 800f, paint)

        // VAN4U Text
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        canvas.drawText("VAN4U EXTERNAL", 350f, 250f, paint)

        paint.color = Color.RED
        paint.style = Paint.Style.STROKE
    }
}
