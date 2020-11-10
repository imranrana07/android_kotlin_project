package com.imranrana.hellohasan.features.post_details.model

import com.imranrana.hellohasan.features.post_list.model.Post

interface PostDetailResponseCallBack {
    fun success(post: Post)
    fun failed(throwable: Throwable)
}