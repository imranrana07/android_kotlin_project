package com.imranrana.hellohasan.features.post_details.presenter

import com.imranrana.hellohasan.features.post_details.view.CommentListView

interface CommentPresenter {
    fun commentView(commentListView: CommentListView)
}