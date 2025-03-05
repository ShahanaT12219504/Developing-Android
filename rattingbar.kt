package com.example.classdemo1

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class rattingbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rattingbar)
        val ratBar=findViewById<RatingBar>(R.id.ratBar)
        val text1=findViewById<TextView>(R.id.text1)
        ratBar.setOnRatingBarChangeListener { _, rating, _ ->
            text1.text ="Your ratting is : $rating"
        }
    }
}