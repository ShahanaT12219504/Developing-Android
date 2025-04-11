package com.example.entrenet

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class PostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_post, container, false)

        val btnPostCommunity = view.findViewById<Button>(R.id.btnPostCommunity)
        val btnStartDiscussion = view.findViewById<Button>(R.id.btnStartDiscussion)
        val btnFindPeople = view.findViewById<Button>(R.id.btnFindPeople)

        btnPostCommunity.setOnClickListener {
            val intent = Intent(activity, PostInCommunityActivity::class.java)
            startActivity(intent) // No need for startActivityForResult
        }

        btnStartDiscussion.setOnClickListener {
            val intent = Intent(activity, StartDiscussionActivity::class.java)
            startActivity(intent)
        }

        btnFindPeople.setOnClickListener {
            val intent = Intent(activity, FindPeopleActivity::class.java)
            startActivity(intent)
        }

        return view
    }

}
