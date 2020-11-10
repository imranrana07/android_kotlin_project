package com.imranrana.myblog.features.post_list.presenter

import com.imranrana.myblog.features.post_list.model.Post
import com.imranrana.myblog.features.post_list.model.PostModelImpl
import com.imranrana.myblog.features.post_list.model.PostResponseCallBack
import com.imranrana.myblog.features.post_list.view.PostListView

class PostPresenterImpl : PostPresenter {
    private val postModelImpl = PostModelImpl()
    private val visible = 0 //view.Visible = 0
    private val gone = 8 //view.Visible = 8

    override fun getListView(postListView: PostListView) {
        postListView.progressBar(visible)
        postModelImpl.getPost(object : PostResponseCallBack {
            override fun success(list: MutableList<Post>) {
                postListView.progressBar(gone)
                postListView.postListView(list)
            }

            override fun errorMessage(errorMessage: String) {
                postListView.progressBar(gone)
                postListView.errorMessage(errorMessage)
            }

            override fun failed(throwable: Throwable) {
                postListView.progressBar(gone)
                postListView.failed(throwable)
            }
        })
    }
    
}