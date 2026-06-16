package com.van4u.external

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.van4u.external.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isEspRunning = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Theme VAN4U Dark Red Black
        window.statusBarColor = ContextCompat.getColor(this, R.color.dark_red)

        ShizukuHelper.init(this)

        setupUI()
    }

    private fun setupUI() {
        binding.tvTitle.text = "VAN4U EXTERNAL"
        binding.tvTitle.setTextColor(Color.RED)

        binding.btnToggle.setOnClickListener {
            isEspRunning = !isEspRunning
            if (isEspRunning) {
                startOverlay()
                binding.btnToggle.text = getString(R.string.stop_esp)
                binding.btnToggle.setBackgroundColor(Color.parseColor("#8B0000"))
            } else {
                stopOverlay()
                binding.btnToggle.text = getString(R.string.start_esp)
                binding.btnToggle.setBackgroundColor(Color.parseColor("#DC143C"))
            }
        }

        binding.btnRefresh.setOnClickListener {
            val pid = MemoryReader.getPidByPackage("com.dts.freefireth")
            Toast.makeText(this, "Game PID: $pid", Toast.LENGTH_SHORT).show()
        }
    }

    private fun startOverlay() {
        val intent = Intent(this, OverlayService::class.java)
        ContextCompat.startForegroundService(this, intent) // or startService
        Toast.makeText(this, "VAN4U ESP Started", Toast.LENGTH_SHORT).show()
    }

    private fun stopOverlay() {
        val intent = Intent(this, OverlayService::class.java)
        stopService(intent)
    }
}
