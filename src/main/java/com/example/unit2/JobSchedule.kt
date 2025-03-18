package com.example.unit2

import android.annotation.SuppressLint
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class JobSchedule : AppCompatActivity() {
     val JOB_ID = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_job_schedule)
val btnbackapp=findViewById<Button>(R.id.btnjobback)
        btnbackapp.setOnClickListener {
            val intent= Intent(this,RemindMeApp::class.java)
            startActivity(intent)
        }
       val btnjob=findViewById<Button>(R.id.btnjob)
        btnjob.setOnClickListener {
            scheduleJob()
        }
    }

    @SuppressLint("ServiceCast")
    private fun scheduleJob() {
        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler

        val componentName = ComponentName(this, JobServicePlan::class.java)

        val jobInfo = JobInfo.Builder(JOB_ID, componentName)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY) // Requires network
            .setRequiresCharging(true) // Requires charging
            .setPersisted(true) // Persist across reboots
            .build()

        val result = jobScheduler.schedule(jobInfo)

        if (result == JobScheduler.RESULT_SUCCESS) {
            Log.d("MainActivity", "Job scheduled successfully!")
        } else {
            Log.d("MainActivity", "Job scheduling failed!")
        }
    }
}