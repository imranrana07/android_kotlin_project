package com.imranrana.myblog.features.post_list.model

interface PostResponseCallBack {
    fun success(list: MutableList<Post>)
    fun errorMessage(errorMessage: String)
    fun failed(throwable: Throwable)
}