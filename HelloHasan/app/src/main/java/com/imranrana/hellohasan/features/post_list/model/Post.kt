package com.imranrana.hellohasan.features.post_list.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Post (
    val id: Int,
    @SerializedName("jetpack_featured_media_url")
    @Expose
    val imageUrl: String,
    var title: PostTitleFromRenderedObj,
    val content: PostContentFromRendered,
    var author: String,
    var date: String
): Serializable{
    data class PostTitleFromRenderedObj (
            var rendered: String
    )

    data class PostContentFromRendered (
            val rendered: String
    )
}