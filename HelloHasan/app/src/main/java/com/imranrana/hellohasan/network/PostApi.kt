package com.imranrana.hellohasan.network

import com.imranrana.hellohasan.features.post_details.model.Comment
import com.imranrana.hellohasan.features.post_list.model.Post
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostApi {

    @GET("posts")
    fun getPosts(): Call<MutableList<Post>>

    @GET("posts/{post_id}")
    fun postDetails(@Path("post_id") postId:Int): Call<Post>
//    https://hellohasan.com/wp-json/wp/v2/comments?post=postId&postId=3248
    @GET("comments?")
    fun postComments(@Query("post") postId: Int): Call<MutableList<Comment>>
}