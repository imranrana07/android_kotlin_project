package com.imranrana.hellohasan.features.post_list.model

interface PostModel {
    fun getPosts(postResponseCallBack: PostResponseCallBack)
}