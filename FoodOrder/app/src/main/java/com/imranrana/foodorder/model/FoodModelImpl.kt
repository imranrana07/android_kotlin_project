package com.imranrana.foodorder.model

import com.imranrana.foodorder.network.FoodApi
import com.imranrana.foodorder.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodModelImpl : FoodModel {
    private val foodApi = RetrofitClient.retrofit?.create(FoodApi::class.java)

    override fun getFoodList(foodResponseCallBack: FoodResponseCallBack){
        foodApi?.getFoodList()?.enqueue(object : Callback<MutableList<Food>>{
            override fun onResponse(
                call: Call<MutableList<Food>>,
                response: Response<MutableList<Food>>
            ) {
                response.body()?.let {
                    foodResponseCallBack.success(it)
                }
            }

            override fun onFailure(call: Call<MutableList<Food>>, t: Throwable) {
                foodResponseCallBack.error(t)
            }

        })
    }
}