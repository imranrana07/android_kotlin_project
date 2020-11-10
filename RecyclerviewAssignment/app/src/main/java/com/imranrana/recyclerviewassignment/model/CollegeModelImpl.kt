package com.imranrana.recyclerviewassignment.model

import com.imranrana.recyclerviewassignment.network.CollegeApiInterface
import com.imranrana.recyclerviewassignment.network.RetrofitClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.create
import java.util.ArrayList

class CollegeModelImpl: CollegeModel {
    private val retrofit = RetrofitClient.retrofit?.create(CollegeApiInterface::class.java)
    private val apiCollegeList = retrofit?.getColleges()

    override fun getList(collegeCallBack: CollegeCallBack) {
        apiCollegeList?.clone()?.enqueue(object : retrofit2.Callback<ArrayList<College>>{
            override fun onResponse(
                call: Call<ArrayList<College>>,
                response: Response<ArrayList<College>>
            ) {
                response.body()?.let { collegeCallBack.success(it) }
            }

            override fun onFailure(call: Call<ArrayList<College>>, t: Throwable) {
                collegeCallBack.error(t)
            }
        })
    }

    fun localStorageData():ArrayList<College>{
        val collegeList = ArrayList<College>()
        for (i in 1..10){
            val college = College("College $i",
                "https://picsum.photos/200",
                "District $i","Chief $i","email Add $i",
                3.6f,"129878212")

            collegeList.add(college)
        }
        return collegeList
    }
}