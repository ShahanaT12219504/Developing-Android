package com.example.unit5

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import  android.Manifest
import android.content.Intent
import android.os.Environment
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.FileReader
import java.io.IOException

class ExternalStorage : AppCompatActivity() {
    lateinit var uname: EditText
    lateinit var pwd: EditText
    lateinit var saveBtn: Button
    lateinit var fstream: FileOutputStream
    private val filename = "SampleFile.txt"
    private val filepath = "MyFileStorage"
    lateinit var myExternalFile: File

    var mPermission = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_external_storage)
        uname = findViewById(R.id.txtName)
        pwd = findViewById(R.id.txtPwd)
        saveBtn = findViewById(R.id.btnSave)
        saveBtn.setOnClickListener {
            val username = """
                ${uname.text}
                
                """.trimIndent()
            val password = pwd.text.toString()
            try {
                if (username.isEmpty() || password.isEmpty())
                    Toast.makeText(this, "either of field is empty", Toast.LENGTH_SHORT).show()
                else {
                    myExternalFile = File(getExternalFilesDir(filepath), filename)
                    fstream = FileOutputStream(myExternalFile)
                    fstream.write(username.toByteArray())
                    fstream.write(password.toByteArray())
                    fstream.close()
                    Toast.makeText(applicationContext, "Details Saved in " + myExternalFile!!.absolutePath, Toast.LENGTH_LONG).show()
                    intent = Intent(this, ExternalDetail::class.java)
                    startActivity(intent)
                }
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}