package com.imranrana.hellohasan.features.post_details.view

import com.imranrana.hellohasan.features.post_details.model.Comment

interface CommentListView {
    fun commentListView(commentList: MutableList<Comment>)
    fun failed(throwable: Throwable)
    fun progressBar(visibility: Int)
}