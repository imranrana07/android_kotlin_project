package com.imranrana.foodorder.features.food_list

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_food.view.*

class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var foodImage = itemView.iv_food!!
    var discountPercentage = itemView.tv_discount!!
    var foodOriginalPrice = itemView.tv_foodOriginalPrice!!
    var isFavorite = itemView.iv_foodIsFavorite!!
    var isNotFavorite = itemView.iv_foodIsNotFavorite!!
    var foodName = itemView.tv_foodName!!
    var discountPrice = itemView.tv_foodDiscountPrice!!
}
