package com.imranrana.myblog.network

import com.imranrana.myblog.features.post_list.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface PostApi {
    @GET("postData")
    fun getPosts(): Call<MutableList<Post>>;
}
