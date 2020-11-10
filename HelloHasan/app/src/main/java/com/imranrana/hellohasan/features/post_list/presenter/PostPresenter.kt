package com.imranrana.hellohasan.features.post_list.presenter

import com.imranrana.hellohasan.features.post_list.view.PostListView

interface PostPresenter {
    fun postListView(postListView: PostListView)
}