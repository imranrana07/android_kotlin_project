package com.imranrana.hellohasan.features.post_details.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imranrana.hellohasan.R
import com.imranrana.hellohasan.features.post_details.model.Comment

class CommentAdapter(private val list: MutableList<Comment>) : RecyclerView.Adapter<CommentsViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_comments,parent,false)
        return CommentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        val comments = list[position]
        Glide.with(context).load("").placeholder(R.drawable.person).into(holder.ivCommentsAuthor)
        holder.tvCommentAuthor.text = comments.author_name
        holder.tvCommentDate.text = comments.date
        holder.tvComment.text = comments.comment.rendered

    }

    override fun getItemCount(): Int {
        return list.size
    }
}