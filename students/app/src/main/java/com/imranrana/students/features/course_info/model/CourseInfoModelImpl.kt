package com.imranrana.students.features.course_info.model

import com.imranrana.students.core.ApiResponseCallback
import com.imranrana.students.core.Utils
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class CourseInfoModelImpl: CourseInfoModel {

    override fun getCourseInfo(apiResponseCallback: ApiResponseCallback<CourseInfoData>) {
        Utils.retrofit().getCourseInfo().enqueue(object : retrofit2.Callback<CourseInfoData> {
            override fun onResponse(call: Call<CourseInfoData>, response: Response<CourseInfoData>) {
                if (response.isSuccessful){
                    response.body()?.let { apiResponseCallback.success(it) }
                }else{
                    val errorMessage = response.errorBody()!!.charStream().readText()
                    apiResponseCallback.error(Throwable(JSONObject(errorMessage).getString("message")))
                }
            }

            override fun onFailure(call: Call<CourseInfoData>, t: Throwable) {
                apiResponseCallback.error(t)
            }
        })
    }
}