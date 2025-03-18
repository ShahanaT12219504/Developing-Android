package com.example.unit2

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class alarm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
                setContentView(R.layout.activity_alarm)
        val alarmback=findViewById<Button>(R.id.alarmback)
        alarmback.setOnClickListener {
            val intent=Intent(this,RemindMeApp::class.java)
            startActivity(intent)
        }
        val btnalarm = findViewById<Button>(R.id.alarm)
        btnalarm.setOnClickListener {
            // Check and request SCHEDULE_EXACT_ALARM permission for Android 12+
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
                if (!alarmManager.canScheduleExactAlarms()) {
                    // Open settings to grant the permission
                    val intent = Intent(Settings.ACTION_REQUEST_SCHEDULE_EXACT_ALARM)
                    startActivity(intent)
                    Toast.makeText(this, "Please grant the exact alarm permission", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            // Set an alarm 10 seconds from now
            setAlarm(10*1000) // 10 seconds in milliseconds
            Toast.makeText(this, "Alarm set for 10 seconds from now", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAlarm(delay: Int) {
        // Get the AlarmManager system service
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

        // Create an Intent to trigger the BroadcastReceiver
        val intent = Intent(this, com.example.unit2.AlarmManager::class.java)
        intent.action = "com.example.ALARM_TRIGGERED"

        // Create a PendingIntent
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0, // Request code (unique for each PendingIntent)
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        // Calculate the trigger time (current time + delay)
        val triggerTime = System.currentTimeMillis() + delay

        // Set the alarm
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            // For Android 6.0 (API 23) and above, use setExactAndAllowWhileIdle for exact alarms
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                triggerTime,
                pendingIntent
            )
        }
    }

}
