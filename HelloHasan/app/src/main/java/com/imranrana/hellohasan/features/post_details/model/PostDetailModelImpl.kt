package com.imranrana.hellohasan.features.post_details.model

import com.imranrana.hellohasan.features.post_list.model.Post
import com.imranrana.hellohasan.network.PostApi
import com.imranrana.hellohasan.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostDetailModelImpl(private val postId: Int): PostDetailModel {
    private val postApi = RetrofitClient.retrofit?.create(PostApi::class.java)

    override fun getPostDetail(postDetailResponseCallBack: PostDetailResponseCallBack) {
        postApi?.postDetails(postId)?.enqueue(object : Callback<Post> {
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                if (response.isSuccessful) {
                    response.body().let {
                        postDetailResponseCallBack.success(it!!)
                    }
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                postDetailResponseCallBack.failed(t)
            }
        })
    }
}