package com.imranrana.foodorder.network

import com.imranrana.foodorder.model.Food
import retrofit2.Call
import retrofit2.http.GET

interface FoodApi {
    @GET("imranrana07/RecyclerviewAssignment/master/food_data")
    fun getFoodList(): Call<MutableList<Food>>
}