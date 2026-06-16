package com.example.externalesp

import java.io.BufferedReader
import java.io.InputStreamReader

import rikka.shizuku.Shizuku

object MemoryReader {
    fun getPid(packageName: String): Int? {
        val cmd = "ps -A | grep $packageName"
        val output = executeCommand(cmd) ?: return null
        return output.lines().firstOrNull()?.trim()?.split("\s+".toRegex())?.getOrNull(1)?.toIntOrNull()
    }

    private fun executeCommand(cmd: String): String? {
        return try {
            val process = Shizuku.newProcess(arrayOf("sh", "-c", cmd), null, null)
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            reader.readText().also { process.destroy() }
        } catch (e: Exception) {
            null
        }
    }

    // TODO: Implement readMemory(address: Long, size: Int): ByteArray using /proc/pid/mem
} 