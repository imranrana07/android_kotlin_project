package com.imranrana.students.features.login.model

import com.imranrana.students.core.ApiResponseCallback

interface LoginModel {
    fun getLoginResponse(authCredential: AuthCredential/*,apiKey: String*/,apiResponseCallback: ApiResponseCallback<LoginJsonResponse>)
}