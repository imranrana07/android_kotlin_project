package com.imranrana.hellohasan.features.post_details.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Comment (
        val commentId: String,
//        @SerializedName("author_avatar_urls")
//        val imageUrl: String,
        val postId: String,
        val parent: String,
        val author_name: String,
        var date: String,
        @SerializedName("content")
        var comment: Content
): Serializable{
    data class Content (
            var rendered: String
    )
}