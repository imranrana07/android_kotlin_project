package com.imranrana.firstclass

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn.setOnClickListener {
            if (isValidEmail() && isPasswordValid()){
                startActivity(Intent(applicationContext,EditProfile::class.java))
                finish()
            }
        }
    }

    private fun isValidEmail(): Boolean {
        when {
            emailEt.text.toString().trim().isEmpty() -> {
                emailEt.error = "Email address required"
                return false
            }
            !Patterns.EMAIL_ADDRESS.matcher(emailEt.text.toString().trim()).matches() -> {
                emailEt.error = "Please enter a valid email address"
                return false
            }
            emailEt.text.toString().trim() == "imranrana07@gmail.com" -> {
                return true
            }
            else -> {
                emailEt.error = "Email address mismatched"
                return false
            }
        }
    }

    private fun isPasswordValid(): Boolean{
        if (passwordEt.text.toString().trim().isEmpty()){
            passwordEt.error = "Password required"
            return false
        }else if(passwordEt.text.toString().trim() != "123456"){
            passwordEt.error = "Password mismatched"
            return false
        }
        return true
    }
}