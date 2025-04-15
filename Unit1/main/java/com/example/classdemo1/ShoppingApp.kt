package com.example.classdemo1

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ShoppingApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shopping_app)
        val ratBar = findViewById<RatingBar>(R.id.ratBar)
        val ratBar1 = findViewById<RatingBar>(R.id.ratBar1)
        val text1 = findViewById<TextView>(R.id.text1)
        ratBar.setOnRatingBarChangeListener { _, rating, _ ->
            text1.text = "Your ratting is : $rating"
        }
        ratBar1.setOnRatingBarChangeListener { _, rating, _ ->
            text1.text = "Your ratting is : $rating"
        }
    }
}