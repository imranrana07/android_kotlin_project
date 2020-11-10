package com.imranrana.students.features.login.model

import android.util.Log
import com.imranrana.students.core.ApiResponseCallback
import com.imranrana.students.core.Utils
import com.imranrana.students.network.RetrofitClient
import com.imranrana.students.network.StudentApis
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginModelImpl: LoginModel {
    private val studentApis = RetrofitClient.retrofit?.create(StudentApis::class.java)

    override fun getLoginResponse(authCredential: AuthCredential,apiResponseCallback: ApiResponseCallback<LoginJsonResponse>) {
        studentApis?.getLoginResponse(authCredential)?.enqueue(object : Callback<LoginJsonResponse> {
            override fun onResponse(call: Call<LoginJsonResponse>, response: Response<LoginJsonResponse>) {
                if(response.isSuccessful) {
                    response.body()?.let {
                        apiResponseCallback.success(it)
                    }
                }else{
                    val errorMessage = JSONObject(response.errorBody()!!.charStream().readText())
                    apiResponseCallback.error(Throwable(errorMessage.getString("message")))
                }
            }

            override fun onFailure(call: Call<LoginJsonResponse>, t: Throwable) {
                apiResponseCallback.error(t)
            }
        })
    }
}