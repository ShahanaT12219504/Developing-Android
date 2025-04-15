package com.example.classdemo1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class listView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_view)

        val listname = findViewById<ListView>(R.id.listname)
        val arr= arrayOf("Shruti","Harshita","Ashmit","Sayjan","Om",
            "Ravi","Mukesh","Amit","Shiwani","Riya","Munawar","Ruchika")
val mad=ArrayAdapter(this,android.R.layout.simple_list_item_1,arr)
        val listfooter= layoutInflater.inflate(R.layout.footerlistview,listname,false) as ViewGroup
        listname.addFooterView(listfooter)
        listname.adapter =mad

    }
}