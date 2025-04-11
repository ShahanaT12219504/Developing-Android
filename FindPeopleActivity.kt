package com.example.entrenet

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class FindPeopleActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var addButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_people)

        editText = findViewById(R.id.editText)
        addButton = findViewById(R.id.addButton)

        addButton.setOnClickListener {
            val text = editText.text.toString()
            val resultIntent = Intent().apply {
                putExtra("FIND_PEOPLE_TEXT", text)
            }
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}
