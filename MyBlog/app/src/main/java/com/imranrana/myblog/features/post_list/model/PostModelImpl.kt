package com.imranrana.myblog.features.post_list.model

import com.imranrana.myblog.network.PostApi
import com.imranrana.myblog.network.RetrofitClient
import retrofit2.Call
import retrofit2.Response

class PostModelImpl : PostModel {
    private val postApi = RetrofitClient.retrofit!!.create(PostApi::class.java)

    override fun getPost(postResponseCallBack: PostResponseCallBack){
        postApi.getPosts().enqueue(object : retrofit2.Callback<MutableList<Post>>{
            override fun onResponse(call: Call<MutableList<Post>>, response: Response<MutableList<Post>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        postResponseCallBack.success(it)
                    }
                }else{
                    response.errorBody()?.string()?.let {
                        postResponseCallBack.errorMessage(it)
                    }
                }
            }

            override fun onFailure(call: Call<MutableList<Post>>, t: Throwable) {
                postResponseCallBack.failed(t)
            }
        })
    }
}