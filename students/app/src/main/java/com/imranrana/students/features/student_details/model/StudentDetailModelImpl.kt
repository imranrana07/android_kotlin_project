package com.imranrana.students.features.student_details.model

import com.imranrana.students.core.ApiResponseCallback
import com.imranrana.students.core.Utils
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class StudentDetailModelImpl: StudentDetailModel {
    
    override fun getDetails(studentId: Int,token: String,apiResponseCallback: ApiResponseCallback<StudentDetails>) {

        Utils.retrofit().getStudentDetails(token,studentId).enqueue(object : retrofit2.Callback<StudentDetails> {
            override fun onResponse(call: Call<StudentDetails>, response: Response<StudentDetails>) {
                if (response.isSuccessful){
                    response.body()?.let { apiResponseCallback.success(it) }
                }else{
                    val errorMessage = JSONObject(response.errorBody()!!.charStream().readText())
                    apiResponseCallback.error(Throwable(errorMessage.getString("message")))
                }
            }

            override fun onFailure(call: Call<StudentDetails>, t: Throwable) {
                apiResponseCallback.error(t)
            }
        })
    }
}