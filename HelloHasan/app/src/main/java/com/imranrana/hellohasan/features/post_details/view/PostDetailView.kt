package com.imranrana.hellohasan.features.post_details.view

import com.imranrana.hellohasan.features.post_list.model.Post

interface PostDetailView {
    fun progressBar(visibility: Int)
    fun postDetailView(post: Post)
    fun failed(throwable: Throwable)
}