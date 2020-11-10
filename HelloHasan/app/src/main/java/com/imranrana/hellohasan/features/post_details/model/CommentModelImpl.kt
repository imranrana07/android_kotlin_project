package com.imranrana.hellohasan.features.post_details.model

import com.imranrana.hellohasan.network.PostApi
import com.imranrana.hellohasan.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentModelImpl(private val postId: Int) : CommentModel {
    private val apis = RetrofitClient.retrofit?.create(PostApi::class.java)

    override fun getComments(commentResponseCallback: CommentResponseCallback) {
        apis?.postComments(postId)?.enqueue(object : Callback<MutableList<Comment>> {
            override fun onResponse(call: Call<MutableList<Comment>>, response: Response<MutableList<Comment>>) {
                response.body().let {
                    commentResponseCallback.success(it!!)
                }
            }

            override fun onFailure(call: Call<MutableList<Comment>>, t: Throwable) {
                commentResponseCallback.failed(t)
            }

        })
    }
}