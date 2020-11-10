package com.imranrana.recyclerviewassignment.network

import com.google.gson.GsonBuilder
import com.imranrana.recyclerviewassignment.core.Utils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val gson = GsonBuilder()
        .setLenient().
        create()

    var retrofit: Retrofit? = null
        get() {
        if (field == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(Utils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return field
    }
}