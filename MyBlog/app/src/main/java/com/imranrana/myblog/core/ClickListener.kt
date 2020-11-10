package com.imranrana.myblog.core

import com.imranrana.myblog.features.post_list.model.Post

interface ClickListener {
    fun itemClick(position: Int,list: MutableList<Post>)
}