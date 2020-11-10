package com.imranrana.students.features.login.presenter

import com.imranrana.students.features.login.view.LoginView

interface LoginPresenter {
    fun getLoginResponse(loginView: LoginView)
}