package com.imranrana.hellohasan.features.post_details.model

interface CommentResponseCallback {
    fun success(list: MutableList<Comment>)
    fun failed(throwable: Throwable)
}