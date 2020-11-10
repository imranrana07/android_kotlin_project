package com.imranrana.students.core

import android.view.View
import com.imranrana.students.network.RetrofitClient
import com.imranrana.students.network.StudentApis
import org.json.JSONObject

class Utils {
    companion object{
        const val BASE_URL = "https://test.hellohasan.com/android-course-api/"
        const val api_key = "VGhpcyBpcyBBUEkgS0VZIGluIGJhc2U2NCBmb3JtYXQ="
        const val userID = "vito@ninja"
        const val password = "12345"
        const val VISIBLE = 0 //View.VISIBLE
        const val GONE = 8 //View.GONE
        const val sharedPreference = "UserData"
        const val studentId = 106

        fun retrofit(): StudentApis{
            return RetrofitClient.retrofit!!.create(StudentApis::class.java)
        }
    }
}