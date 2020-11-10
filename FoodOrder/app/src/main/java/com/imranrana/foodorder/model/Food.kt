package com.imranrana.foodorder.model

import android.os.Parcelable
import java.io.Serializable

data class Food (
    val id: String,
    val name: String,
    val imageUrl: String,
    val discountRatio: String,
    val originalPrice: String,
    val discountPrice: String,
    val isFavorite: Boolean,
): Serializable