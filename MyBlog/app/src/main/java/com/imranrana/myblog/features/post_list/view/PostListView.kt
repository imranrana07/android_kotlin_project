package com.imranrana.myblog.features.post_list.view

import com.imranrana.myblog.features.post_list.model.Post

interface PostListView {
    fun progressBar(isVisible: Int)
    fun postListView(list: MutableList<Post>)
    fun errorMessage(message: String)
    fun failed(throwable: Throwable)
}