package com.example.entrenet

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PostInCommunityActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var postButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_in_community)

        editText = findViewById(R.id.editText)
        postButton = findViewById(R.id.postButton)

        postButton.setOnClickListener {
            val text = editText.text.toString().trim()

            if (text.isNotEmpty()) {
                val post = Post(text)

                val mainActivity = getParentActivity() as? MainActivity
                val activityFragment = mainActivity?.getActivityFragment()

//                if (activityFragment != null) {
//                    activityFragment.addNewPost(post)  // ✅ Update the list in `ActivityFragment`
//                    finish()  // ✅ Close `PostInCommunityActivity`
//                } else {
//                    Toast.makeText(this, "Error: ActivityFragment not found!", Toast.LENGTH_SHORT).show()
//                }
            }
        }
    }

    private fun getParentActivity(): AppCompatActivity? {
        return this as? AppCompatActivity
    }
}
