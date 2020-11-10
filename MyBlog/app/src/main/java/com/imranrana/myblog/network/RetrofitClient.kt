package com.imranrana.myblog.network

import com.google.gson.GsonBuilder
import com.imranrana.myblog.core.Utils
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val gson = GsonBuilder()
            .setLenient()
            .create()

    var retrofit: Retrofit? = null
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