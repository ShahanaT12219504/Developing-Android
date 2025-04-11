package com.example.entrenet

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class JobSchedulerService : JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d("JobSchedulerService", "Job Started!")
        return false
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        Log.d("JobSchedulerService", "Job Stopped!")
        return false
    }
}