package com.imranrana.hellohasan.features.post_list.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.imranrana.hellohasan.R
import com.imranrana.hellohasan.core.BaseActivity
import com.imranrana.hellohasan.features.post_list.model.ItemClickListener
import com.imranrana.hellohasan.features.post_details.view.PostDetailsActivity
import com.imranrana.hellohasan.features.post_list.adapter.PostAdapter
import com.imranrana.hellohasan.features.post_list.model.Post
import com.imranrana.hellohasan.features.post_list.presenter.PostPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tool_bar.*

class MainActivity : BaseActivity(), PostListView, ItemClickListener {

    override val isHomeButtonEnabled: Boolean get() = false
    override fun setLayout(): Int = R.layout.activity_main
    private val postPresenterImpl = PostPresenterImpl()

    override fun setLayoutActionBar(): Toolbar {
        toolBar.title = "Home"
        return toolBar
    }

    override fun progressBar(isVisible: Int) {
        progressBar.visibility = isVisible
    }

    override fun postListView(list: MutableList<Post>) {
        showPosts(list)
    }
    override fun failed(throwable: Throwable) {
        throwable.message?.let {
            showToast(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postPresenterImpl.postListView(this)
    }

    private fun showPosts(list: MutableList<Post>){
        val adapter = PostAdapter(list, this)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
    }

    override fun itemClick(postId: Int, postTitle: String) {
        val intent = Intent(this, PostDetailsActivity::class.java)
        intent.putExtra("postId",postId)
        intent.putExtra("postTitle",postTitle)
        startActivity(intent)
    }
}