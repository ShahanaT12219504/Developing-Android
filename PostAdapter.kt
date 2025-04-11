package com.example.entrenet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PostAdapter(private val postList: List<Post>) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    // ViewHolder that holds the reference to the views
    class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val postText: TextView = itemView.findViewById(R.id.postText)
    }

    // Create a new view holder for the post
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    // Bind the data to the TextView (post content)
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = postList[position]
        // Assuming you want to display post content or title
        holder.postText.text = post.content // Or use post.title if you prefer
    }

    override fun getItemCount(): Int = postList.size
}
