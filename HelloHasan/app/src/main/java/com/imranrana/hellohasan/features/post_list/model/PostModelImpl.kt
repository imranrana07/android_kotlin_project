package com.imranrana.hellohasan.features.post_list.model

import com.imranrana.hellohasan.network.PostApi
import com.imranrana.hellohasan.network.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class PostModelImpl: PostModel {
    private val apis = RetrofitClient.retrofit?.create(PostApi::class.java)

    override fun getPosts(postResponseCallBack: PostResponseCallBack) {
        apis?.getPosts()?.enqueue(object : retrofit2.Callback<MutableList<Post>>{
            override fun onResponse(
                call: Call<MutableList<Post>>,
                response: Response<MutableList<Post>>
            ) {
                response.body().let {
                    postResponseCallBack.success(it!!)
                }
            }

            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                postResponseCallBack.failed(t)
            }
        })
    }
}