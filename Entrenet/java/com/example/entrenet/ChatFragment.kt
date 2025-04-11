package com.example.entrenet

import ChatAdapter
import ChatItem
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ChatAdapter
    private lateinit var chatList: List<ChatItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_chat, container, false)

        recyclerView = view.findViewById(R.id.chat_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        chatList = listOf(
            ChatItem("Elon Musk", "Let’s connect over Mars colonization!", R.drawable.elon),
            ChatItem("Jeff Bezos", "Exploring new markets!", R.drawable.bezos),
            ChatItem("Mark Zuckerberg", "Meta updates coming soon.", R.drawable.zuck),
            ChatItem("Sundar Pichai", "Excited about AI at Google.", R.drawable.pichai),
            ChatItem("Steve Jobs", "Stay hungry, stay foolish.", R.drawable.cook),
            ChatItem("Ratan Tata", "Let’s build something meaningful.", R.drawable.mukesh)
        )

        adapter = ChatAdapter(chatList)
        recyclerView.adapter = adapter

        return view
    }
}
