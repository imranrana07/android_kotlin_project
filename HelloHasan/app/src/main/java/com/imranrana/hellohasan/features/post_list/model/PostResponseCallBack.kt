package com.imranrana.hellohasan.features.post_list.model

interface PostResponseCallBack {
    fun success(list: MutableList<Post>)
    fun failed(throwable: Throwable)
}