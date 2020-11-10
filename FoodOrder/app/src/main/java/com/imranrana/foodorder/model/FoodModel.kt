package com.imranrana.foodorder.model

interface FoodModel {
    fun getFoodList(foodResponseCallBack: FoodResponseCallBack)
}