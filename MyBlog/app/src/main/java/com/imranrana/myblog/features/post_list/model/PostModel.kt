package com.imranrana.myblog.features.post_list.model

interface PostModel {
    fun getPost(postResponseCallBack: PostResponseCallBack)
}