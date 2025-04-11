package com.example.entrenet

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProfileFragment : Fragment() {

    private lateinit var recyclerViewPosts: RecyclerView
    private lateinit var postAdapter: PostAdapterProfile
    private val postList = listOf(
        R.drawable.img, R.drawable.img, R.drawable.img,
        R.drawable.img, R.drawable.img, R.drawable.img
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        // Setup RecyclerView
        recyclerViewPosts = view.findViewById(R.id.recyclerView_posts)
        recyclerViewPosts.layoutManager = GridLayoutManager(requireContext(), 3) // 3-column grid
        postAdapter = PostAdapterProfile(postList)
        recyclerViewPosts.adapter = postAdapter

        // Add spacing between grid items
        recyclerViewPosts.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                outRect.set(8, 8, 8, 8) // Left, Top, Right, Bottom margin
            }
        })

        return view
    }
}
