package com.imranrana.students.network

import com.imranrana.students.core.Utils
import com.imranrana.students.features.course_info.model.CourseInfoData
import com.imranrana.students.features.login.model.AuthCredential
import com.imranrana.students.features.login.model.LoginJsonResponse
import com.imranrana.students.features.student_details.model.StudentDetails
import com.imranrana.students.features.student_list.model.StudentsJsonResponse
import retrofit2.Call
import retrofit2.http.*

interface StudentApis {
    @GET("course_info.php")
    fun getCourseInfo(): Call<CourseInfoData>

    @Headers("api_key:${Utils.api_key}")
    @POST("login.php")
    fun getLoginResponse(@Body authCredential: AuthCredential): Call<LoginJsonResponse>

    @Headers("api_key:${Utils.api_key}")
    @GET("student.php")
    fun getStudentList(@Header("token") token: String): Call<StudentsJsonResponse>

    @Headers("api_key:${Utils.api_key}")
    @GET("student.php")
    fun getStudentDetails(@Header("token") token: String,@Query("id") id: Int): Call<StudentDetails>
}