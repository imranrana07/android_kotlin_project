package com.imranrana.students.features.student_list.model

import com.imranrana.students.core.ApiResponseCallback
import com.imranrana.students.network.RetrofitClient
import com.imranrana.students.network.StudentApis
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class StudentModelImpl: StudentModel {
    private val studentApis = RetrofitClient.retrofit?.create(StudentApis::class.java)
    override fun getStudentList(token: String,apiResponseCallback: ApiResponseCallback<StudentsJsonResponse>) {
        studentApis?.getStudentList(token)?.enqueue(object : retrofit2.Callback<StudentsJsonResponse> {
            override fun onResponse(call: Call<StudentsJsonResponse>, response: Response<StudentsJsonResponse>) {
                if (response.isSuccessful){
                    response.body()?.let { apiResponseCallback.success(it) }
                }else{
                    val errorMessage = JSONObject(response.errorBody()!!.charStream().readText())
                    apiResponseCallback.error(Throwable(errorMessage.getString("message")))
                }
            }

            override fun onFailure(call: Call<StudentsJsonResponse>, t: Throwable) {
                apiResponseCallback.error(t)
            }

        })
    }
}