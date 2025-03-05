package com.example.classdemo1

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProgressBar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_progress_bar)

val progress=findViewById<View>(R.id.prg)
        val btn=findViewById<Button>(R.id.btn)
       btn.setOnClickListener {
           progress.visibility=View.VISIBLE
           
btn.isEnabled=false
       }
    }
}