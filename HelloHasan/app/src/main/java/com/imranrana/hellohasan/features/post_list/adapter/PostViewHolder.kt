package com.imranrana.hellohasan.features.post_list.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivPost = itemView.iv_post!!
    val tvPostTitle = itemView.tv_postTitle!!
    val tvPostAuthor = itemView.tv_postAuthor!!
    val tvPostModified = itemView.tv_postDate!!
}
