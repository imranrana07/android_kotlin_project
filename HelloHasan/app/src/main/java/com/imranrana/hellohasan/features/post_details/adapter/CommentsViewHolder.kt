package com.imranrana.hellohasan.features.post_details.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_comments.view.*

class CommentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivCommentsAuthor = itemView.iv_commentsAuthor
    val tvCommentAuthor = itemView.tv_commentAuthor
    val tvCommentDate = itemView.tv_commentDate
    val tvComment = itemView.tv_comment
}
