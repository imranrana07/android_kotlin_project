package com.imranrana.hellohasan.features.post_list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.imranrana.hellohasan.R
import com.imranrana.hellohasan.features.post_list.model.ItemClickListener
import com.imranrana.hellohasan.features.post_list.model.Post

class PostAdapter(private val list: MutableList<Post>, private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<PostViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_post,parent,false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val post = list[position]
        Glide.with(context).load(post.imageUrl).into(holder.ivPost)
        holder.tvPostTitle.text  = post.title.rendered
        holder.tvPostAuthor.text = post.author
        holder.tvPostModified.text = post.date

        holder.itemView.setOnClickListener{
            itemClickListener.itemClick(list[position].id,list[position].title.rendered)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}