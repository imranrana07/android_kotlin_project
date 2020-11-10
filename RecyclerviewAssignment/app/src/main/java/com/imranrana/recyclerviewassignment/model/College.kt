package com.imranrana.recyclerviewassignment.model

import java.io.Serializable


data class College (
    val name: String,
    val imageUrl: String,
    val district: String,
    val chief: String,
    val email: String,
    val rating: Float,
    val phoneNo: String
) : Serializable