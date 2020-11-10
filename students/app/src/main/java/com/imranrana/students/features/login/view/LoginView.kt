package com.imranrana.students.features.login.view

import com.imranrana.students.features.login.model.AuthCredential
import com.imranrana.students.features.login.model.LoginJsonResponse

interface LoginView {
    fun progressbar(visibilityStatus: Int)
    fun invalidInput(authCredential: AuthCredential)
    fun success(data: LoginJsonResponse)
    fun error(throwable: Throwable)
}