package com.imranrana.hellohasan.features.post_list.presenter

import android.text.Html
import android.util.Log
import android.view.View
import androidx.core.text.HtmlCompat
import com.imranrana.hellohasan.core.Utils
import com.imranrana.hellohasan.features.post_list.model.Post
import com.imranrana.hellohasan.features.post_list.model.PostModelImpl
import com.imranrana.hellohasan.features.post_list.model.PostResponseCallBack
import com.imranrana.hellohasan.features.post_list.view.PostListView
import com.imranrana.hellohasan.network.PostApi
import com.imranrana.hellohasan.network.RetrofitClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import java.text.SimpleDateFormat

class PostPresenterImpl: PostPresenter {
    private val postModelImpl = PostModelImpl()
    private val VISIBLE = 0 //View.VISIBLE = 0
    private val GONE = 8 //View.GONE = 8

    override fun postListView(postListView: PostListView) {
        
        postModelImpl.getPosts(object : PostResponseCallBack {
            override fun success(list: MutableList<Post>) {
                postListView.postListView(postList(list))
                postListView.progressBar(GONE)
            }

            override fun failed(throwable: Throwable) {
                postListView.failed(throwable)
                postListView.progressBar(GONE)
            }
        })
    }

    private fun postList(list: MutableList<Post>) : MutableList<Post> {
        for (post in list){
            post.title.rendered = Utils.htmlToString(post.title.rendered)
            post.author = getAuthor(post.author)
            post.date = Utils.dateFormat(post.date)
        }
        return list
    }

    /*private fun setTitle(title: String): String {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            HtmlCompat.fromHtml( title, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
        }else{
            Html.fromHtml(title).toString()
        }
    }*/

    private fun getAuthor(author: String): String{
        return if (author == "1") {
            "By "+ Utils.AUTHOR
        }else{
            "By $author"
        }
    }

/*    private fun dateFormat(originalDate: String): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        var convertedDate = sdf.parse(originalDate)
        return SimpleDateFormat("dd MMMM, yyyy").format(convertedDate)
    }*/

}