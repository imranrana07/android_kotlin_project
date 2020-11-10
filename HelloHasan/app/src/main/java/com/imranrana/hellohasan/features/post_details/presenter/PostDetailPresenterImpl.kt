package com.imranrana.hellohasan.features.post_details.presenter

import com.imranrana.hellohasan.core.Utils
import com.imranrana.hellohasan.features.post_details.model.PostDetailModelImpl
import com.imranrana.hellohasan.features.post_details.model.PostDetailResponseCallBack
import com.imranrana.hellohasan.features.post_details.view.PostDetailView
import com.imranrana.hellohasan.features.post_list.model.Post

class PostDetailPresenterImpl(private val postId: Int): PostDetailPresenter {
    private val postDetailModeImpl = PostDetailModelImpl(postId)

    override fun postDetailView(postDetailView: PostDetailView) {
        postDetailModeImpl.getPostDetail(object : PostDetailResponseCallBack {
            override fun success(post: Post) {
                postDetailView.progressBar(Utils.GONE)
                postDetailView.postDetailView(post)
            }

            override fun failed(throwable: Throwable) {
                postDetailView.progressBar(Utils.GONE)
                postDetailView.failed(throwable)
            }
        })
    }
}