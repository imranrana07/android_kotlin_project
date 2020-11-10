package com.imranrana.secondassignment.view

import android.content.Intent
import android.os.Bundle
import com.imranrana.secondassignment.R
import com.imranrana.secondassignment.core.BaseActivity
import com.imranrana.secondassignment.data.MainActivityModelImpl
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    private lateinit var mainActivityModelImpl: MainActivityModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mainActivityModelImpl = MainActivityModelImpl(this)


        if (mainActivityModelImpl.getLoginStatus() != null &&
            mainActivityModelImpl.getLoginStatus() == true){
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        btn_login.setOnClickListener {
            if (isLoginCredentialValid()){
                if (isLoginCredentialMatched()) {
                    mainActivityModelImpl.setLoginStatus(true)
                    startActivity(Intent(this, ProfileActivity::class.java))
                    showLongToast("Login successful")
                }
            }
        }

        btn_register.setOnClickListener{
            startActivity(Intent(this, RegistrationActivity::class.java))
        }

    }

    private fun isLoginCredentialValid() : Boolean{
        if (et_email.text.toString().isEmpty()){
            et_email.error = "Please enter email"
            return false
        }
        if (et_password.text.toString().isEmpty()){
            et_password.error = "Password required"
            return false
        }
        return true
    }

    private fun isLoginCredentialMatched():Boolean {
        if (et_email.text.toString() != mainActivityModelImpl.getEmail()){
            et_email.error = "email mismatched"
            return false
        }

        if (et_password.text.toString() != mainActivityModelImpl.getPassword()){
            et_password.error = "Password mismatched"
            return false
        }
        return true
    }
}