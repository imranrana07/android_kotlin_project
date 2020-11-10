package com.imranrana.hellohasan.features.post_details.presenter

import com.imranrana.hellohasan.core.Utils
import com.imranrana.hellohasan.features.post_details.model.Comment
import com.imranrana.hellohasan.features.post_details.model.CommentModelImpl
import com.imranrana.hellohasan.features.post_details.model.CommentResponseCallback
import com.imranrana.hellohasan.features.post_details.view.CommentListView

class CommentPresenterImpl(private val postId: Int): CommentPresenter {
    private val commentModelImpl = CommentModelImpl(postId)
    override fun commentView(commentListView: CommentListView) {
        commentModelImpl.getComments(object : CommentResponseCallback {
            override fun success(list: MutableList<Comment>) {
                for (comments in list){
                    comments.date = Utils.dateFormatWithTime(comments.date)
                    comments.comment.rendered = Utils.htmlToString(comments.comment.rendered)
                }
                commentListView.commentListView(list)
                commentListView.progressBar(Utils.GONE)
            }

            override fun failed(throwable: Throwable) {
                commentListView.failed(throwable)
                commentListView.progressBar(Utils.GONE)
            }
        })
    }

}