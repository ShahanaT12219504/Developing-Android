package com.example.entrenet

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class JobschedulerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobscheduler)

        val btnScheduleJob: Button = findViewById(R.id.btnScheduleJob)
        btnScheduleJob.setOnClickListener {
            scheduleJob()
        }
    }

    private fun scheduleJob() {
        val componentName = ComponentName(this, JobSchedulerService::class.java)
        val jobInfo = JobInfo.Builder(1, componentName)
            .setRequiresCharging(true)
            .setMinimumLatency(10000) // 10 seconds
            .build()

        val jobScheduler = getSystemService(JobScheduler::class.java)
        jobScheduler.schedule(jobInfo)
        Toast.makeText(this, "Job Scheduled!", Toast.LENGTH_SHORT).show()
    }
}