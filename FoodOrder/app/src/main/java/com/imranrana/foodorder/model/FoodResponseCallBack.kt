package com.imranrana.foodorder.model

interface FoodResponseCallBack {
    fun success(list: MutableList<Food>)
    fun error(throwable: Throwable)
}