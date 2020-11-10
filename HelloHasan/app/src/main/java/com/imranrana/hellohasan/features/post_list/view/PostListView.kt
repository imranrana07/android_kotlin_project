package com.imranrana.hellohasan.features.post_list.view

import com.imranrana.hellohasan.features.post_list.model.Post

interface PostListView {
    fun progressBar(isVisible: Int)
    fun postListView(list: MutableList<Post>)
    fun failed(throwable: Throwable)
}