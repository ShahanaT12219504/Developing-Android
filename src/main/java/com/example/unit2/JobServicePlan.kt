package com.example.unit2

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class JobServicePlan : JobService() {

    override fun onStartJob(params: JobParameters?): Boolean {
        // This is where your job logic goes
        Log.d("MyJobService", "Job started!")

        // Simulate some work
        Thread {
            // Simulate a long-running task
            Thread.sleep(5000)
            Log.d("MyJobService", "Job finished!")

            // Call jobFinished to inform the system that the job is done
            jobFinished(params, false)
        }.start()

        // Return true if the job is running on a separate thread
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        // Called if the job is stopped before finishing
        Log.d("MyJobService", "Job stopped!")
        return false // Return true to reschedule the job
    }
}