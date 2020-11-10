package com.imranrana.myblog.features.post_list.view

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.imranrana.myblog.R
import com.imranrana.myblog.core.BaseActivity
import com.imranrana.myblog.core.ClickListener
import com.imranrana.myblog.features.post_list.model.Post
import com.imranrana.myblog.features.post_list.presenter.PostPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tool_bar.*

class MainActivity : BaseActivity(),PostListView,ClickListener {
    override val isHomeButtonEnabled: Boolean get() = false
    override fun setLayout(): Int = R.layout.activity_main
    override fun setToolBar(): Toolbar {
        toolbar.title = "Posts"
        return toolbar
    }
    private val postPresenterImpl = PostPresenterImpl()
    override fun progressBar(isVisible: Int) {
        progressBar.visibility = isVisible
    }

    override fun postListView(list: MutableList<Post>) {
        showList(list)
    }

    override fun errorMessage(message: String) {
        showToast(message)
    }

    override fun failed(throwable: Throwable) {
        throwable.message?.let { showToast(it) }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postPresenterImpl.getListView(this)
    }

    private fun showList(list: MutableList<Post>){
        val postAdapter = PostAdapter(list,this)
        val linearLayoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)
        rv_post.layoutManager = linearLayoutManager
        rv_post.adapter = postAdapter
    }

    override fun itemClick(position: Int, list: MutableList<Post>) {
        showToast(list[position].postContent)
    }

}