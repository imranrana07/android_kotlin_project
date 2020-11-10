package com.imranrana.students.features.login.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import com.imranrana.students.R
import com.imranrana.students.core.ApiResponseCallback
import com.imranrana.students.core.BaseActivity
import com.imranrana.students.core.Utils
import com.imranrana.students.core.sharedpreference.SharedPreferenceModel
import com.imranrana.students.core.sharedpreference.SharedPreferenceModelImpl
import com.imranrana.students.features.login.model.AuthCredential
import com.imranrana.students.features.login.model.LoginJsonResponse
import com.imranrana.students.features.login.model.LoginModelImpl
import com.imranrana.students.features.login.presenter.LoginPresenterImpl
import com.imranrana.students.features.student_list.view.StudentListActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tool_bar.*

class Login : BaseActivity(),LoginView, ApiResponseCallback<LoginJsonResponse>{
    lateinit var loginPresenterImpl: LoginPresenterImpl
    lateinit var sharedPreferenceModelImpl: SharedPreferenceModelImpl
    override fun setLayout(): Int = R.layout.activity_main
    override val isHomeDisplayEnabled: Boolean get() = true
    override fun setToolbar(): Toolbar {
        tool_bar.title = "Login"
        return tool_bar
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceModelImpl = SharedPreferenceModelImpl(this)
        btn_login.setOnClickListener{
            loginPresenterImpl = LoginPresenterImpl(authCredential(),Utils.api_key,this)
            loginPresenterImpl.getLoginResponse(this)
        }

    }

    override fun progressbar(visibilityStatus: Int) {
        progressBar.visibility = visibilityStatus
    }

    override fun invalidInput(authCredential: AuthCredential) {
        if (authCredential.email.isEmpty()){
            emailError()
        }
        if (authCredential.password.isEmpty()){
            passwordError()
        }
    }

    override fun success(data: LoginJsonResponse) {
        showToast("Login successful")
        sharedPreferenceModelImpl.saveString(SharedPreferenceModel.TOKEN,data.token)
        startActivity(Intent(this,StudentListActivity::class.java))
    }

    override fun error(throwable: Throwable) {
        throwable.message?.let {
            showToast(it)
        }
    }

    private fun authCredential(): AuthCredential{
        return AuthCredential(email(),password())
    }

    private fun email(): String{
        return et_email.text.toString()
    }

    private fun password(): String{
        return et_password.text.toString()
    }

    private fun emailError(){
        et_email.error = "Required"
    }

    private fun passwordError(){
        et_password.error = "Required"
    }

}