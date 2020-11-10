package com.imranrana.hellohasan.features.post_details.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.widget.Toolbar
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.imranrana.hellohasan.R
import com.imranrana.hellohasan.core.BaseActivity
import com.imranrana.hellohasan.features.post_details.adapter.CommentAdapter
import com.imranrana.hellohasan.features.post_details.model.Comment
import com.imranrana.hellohasan.features.post_details.presenter.CommentPresenterImpl
import com.imranrana.hellohasan.features.post_details.presenter.PostDetailPresenterImpl
import com.imranrana.hellohasan.features.post_list.model.Post
import kotlinx.android.synthetic.main.activity_post_details.*
import kotlinx.android.synthetic.main.comment_dialog_layout.view.*


class PostDetailsActivity : BaseActivity(), PostDetailView,CommentListView{

    override fun setLayout(): Int = R.layout.activity_post_details
    private lateinit var postDetailPresenterImpl: PostDetailPresenterImpl
    private lateinit var recyclerViewComment: RecyclerView

    override fun setLayoutActionBar(): Toolbar {
        tool_bar.title = intent.getStringExtra("postTitle")
        return tool_bar
    }

    override val isHomeButtonEnabled: Boolean get() = true

    override fun progressBar(visibility: Int) {
        progressBar.visibility = visibility
    }

    override fun postDetailView(post: Post) {
        showPostDetail(post)
    }

    override fun commentListView(commentList: MutableList<Comment>) {
        showComments(commentList)
    }

    override fun failed(throwable: Throwable) {
        throwable.message?.let {
            showToast(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val postId = intent.getIntExtra("postId",-1)
        postDetailPresenterImpl = PostDetailPresenterImpl(postId)
        postDetailPresenterImpl.postDetailView(this)

        fab.setOnClickListener{
            showCommentDialog(postId)
        }
    }

    private fun showPostDetail(post: Post){
        tv_postDetails.text = setPostDetailInTv(post.content.rendered)
        Glide.with(this).load(post.imageUrl).placeholder(R.drawable.error_image).into(iv_postDetail)
    }

    private fun setPostDetailInTv(postContent: String): String{
        return HtmlCompat.fromHtml(postContent,HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
    }

    private fun showCommentDialog(postId: Int){
        val commentPresenterImpl = CommentPresenterImpl(postId)
        val bottomSheetDialog = BottomSheetDialog(this)
        val view = LayoutInflater.from(this).inflate(R.layout.comment_dialog_layout,null)
        recyclerViewComment = view.recyclerView_comments

        bottomSheetDialog.setContentView(view)
        bottomSheetDialog.show()
//        val commentFragment = CommentFragment()
//        commentFragment.showNow(supportFragmentManager,"CommentDialog")
        commentPresenterImpl.commentView(this)
    }

    private fun showComments(list: MutableList<Comment>){
        val commentAdapter = CommentAdapter(list)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,true)
        recyclerViewComment.layoutManager = linearLayoutManager
        recyclerViewComment.adapter = commentAdapter
    }

}