//package com.example.entrenet
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//
//class ActivityFragment : Fragment() {
//
//    private lateinit var recyclerView: RecyclerView
//    private lateinit var postAdapter: PostAdapter
//    private val postList = mutableListOf<Post>()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val view = inflater.inflate(R.layout.fragment_activity, container, false)
//
//        recyclerView = view.findViewById(R.id.recyclerViewPosts)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//
//        postAdapter = PostAdapter(postList)
//        recyclerView.adapter = postAdapter
//
//        return view
//    }
//
//    // Function to add new posts dynamically
//    fun addNewPost(post: Post) {
//        requireActivity().runOnUiThread {
//            postList.add(0, post) // Add new post to the top
//            postAdapter.notifyItemInserted(0)
//            recyclerView.scrollToPosition(0)
//        }
//    }
//}
//
