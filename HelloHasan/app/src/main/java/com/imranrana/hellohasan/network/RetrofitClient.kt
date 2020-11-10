package com.imranrana.hellohasan.network

import com.google.gson.GsonBuilder
import com.imranrana.hellohasan.core.Utils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val gson = GsonBuilder().setLenient().create()

    var retrofit : Retrofit? = null
        @Synchronized
        get(){
            if (field == null){
                retrofit = Retrofit
                    .Builder()
                    .baseUrl(Utils.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()
            }
            return field!!
        }
}