package com.imranrana.myblog.features.post_list.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvPost = itemView.tv_post
    val tvPostViewCount = itemView.tv_postViewCount
    val tvEmail = itemView.tv_email
    val tvPhone = itemView.tv_phone
}