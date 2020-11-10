package com.imranrana.myblog.features.post_list.presenter

import com.imranrana.myblog.features.post_list.view.PostListView

interface PostPresenter {
    fun getListView(postListView: PostListView)
}