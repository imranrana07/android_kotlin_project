package com.imranrana.myblog.features.post_list.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.imranrana.myblog.R
import com.imranrana.myblog.core.ClickListener
import com.imranrana.myblog.features.post_list.model.Post

class PostAdapter(private val list: MutableList<Post>,private val clickListener: ClickListener): RecyclerView.Adapter<PostViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = list[position]

        holder.tvPost.text = post.postContent
        holder.tvPostViewCount.text = post.postViewCount
        holder.tvEmail.text = post.email
        holder.tvPhone.text = post.phone

        holder.itemView.setOnClickListener {
            clickListener.itemClick(position,list)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}