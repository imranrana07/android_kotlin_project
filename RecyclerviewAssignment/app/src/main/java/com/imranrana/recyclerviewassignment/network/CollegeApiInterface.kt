package com.imranrana.recyclerviewassignment.network

import com.imranrana.recyclerviewassignment.model.College
import retrofit2.Call
import retrofit2.http.GET

interface CollegeApiInterface {
    @GET("imranrana07/RecyclerviewAssignment/master/data")
    fun getColleges(): Call<ArrayList<College>>
}