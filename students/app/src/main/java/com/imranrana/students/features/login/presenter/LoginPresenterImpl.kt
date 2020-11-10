package com.imranrana.students.features.login.presenter

import com.imranrana.students.core.ApiResponseCallback
import com.imranrana.students.core.Utils
import com.imranrana.students.core.sharedpreference.SharedPreferenceModel
import com.imranrana.students.core.sharedpreference.SharedPreferenceModelImpl
import com.imranrana.students.features.login.model.AuthCredential
import com.imranrana.students.features.login.model.LoginJsonResponse
import com.imranrana.students.features.login.model.LoginModelImpl
import com.imranrana.students.features.login.view.LoginView

class LoginPresenterImpl(
        private val authCredential: AuthCredential,
        private val apiKey: String,
        private val apiResponseCallback: ApiResponseCallback<LoginJsonResponse>,
): LoginPresenter {
    private val loginModelImpl = LoginModelImpl()

    override fun getLoginResponse(loginView: LoginView) {
        loginView.progressbar(Utils.VISIBLE)

        if (!isValidInputs()){
            loginView.progressbar(Utils.GONE)
            loginView.invalidInput(authCredential)
            return
        }

        loginModelImpl.getLoginResponse(authCredential, /*apiKey,*/ object : ApiResponseCallback<LoginJsonResponse> {
            override fun success(data: LoginJsonResponse) {
                loginView.progressbar(Utils.GONE)
                apiResponseCallback.success(data)
            }

            override fun error(throwable: Throwable) {
                loginView.progressbar(Utils.GONE)
                apiResponseCallback.error(throwable)
            }
        })
    }

    private fun isValidInputs(): Boolean{
        return if (authCredential.email.isNotEmpty() && authCredential.password.isNotEmpty()){
            true
        }else{
           return false
        }
    }

}