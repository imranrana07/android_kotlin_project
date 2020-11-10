package com.imranrana.secondassignment.view

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.webkit.URLUtil
import android.widget.Toast
import com.imranrana.secondassignment.R
import com.imranrana.secondassignment.core.BaseActivity
import com.imranrana.secondassignment.data.ProfileInformationModelImpl
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : BaseActivity() {
    private lateinit var registrationActivityModelImpl: ProfileInformationModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setActionBar("Registration",true)
        registrationActivityModelImpl = ProfileInformationModelImpl(this)

        btn_registrationSubmit.setOnClickListener {
            if (isCredentialValid()) {
                saveRegistrationInfo()
                startActivity(Intent(this, LoginActivity::class.java))
                Toast.makeText(applicationContext,"Registration successful",Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun isCredentialValid(): Boolean{
        return isNameValid() && isPhoneValid() && isValidEmail()
                && isPasswordValid() && isValidWebsite() && isAgeEmpty()
                && isWeightEmpty() && isImageUrlEmpty() && isGenderSelected()
    }

    private fun saveRegistrationInfo(){
        registrationActivityModelImpl.setName(et_name.text.toString())
        registrationActivityModelImpl.setAge(et_age.text.toString().toInt())
        registrationActivityModelImpl.setWeight(et_weight.text.toString().toFloat())
        if (rb_male.isChecked)
            registrationActivityModelImpl.setGender(rb_male.text.toString())
        else
            registrationActivityModelImpl.setGender(rb_female.text.toString())
        registrationActivityModelImpl.setPhone(et_phone.text.toString().toLong())
        if (cb_notification.isChecked)
            registrationActivityModelImpl.setNotification(true)
        else{
            registrationActivityModelImpl.setNotification(false)
        }
        registrationActivityModelImpl.setEmail(et_email.text.toString())
        registrationActivityModelImpl.setPassword(et_password.text.toString())
        registrationActivityModelImpl.setImageUrl(et_imageUrl.text.toString())
        registrationActivityModelImpl.setWebsite(et_website.text.toString())

    }

    private fun isNameValid() : Boolean{
        if (et_name.text.toString().isEmpty()){
            et_name.error = "Name required"
            return false
        }
        return true
    }

    private fun isAgeEmpty() : Boolean{
        if (et_age.text.toString().isEmpty()){
            et_age.error = "Age required"
            return false
        }
        return true
    }

    private fun isWeightEmpty() : Boolean{
        if (et_weight.text.toString().isEmpty()){
            et_weight.error = "Weight required"
            return false
        }
        return true
    }

    private fun isPhoneValid() : Boolean{
        if (et_phone.text.toString().isEmpty()){
            et_phone.error = "Name required"
            return false
        }
        return true
    }

    private fun isValidEmail(): Boolean {
        when {
            et_email.text.toString().trim().isEmpty() -> {
                et_email.error = "Email address required"
                return false
            }
            !Patterns.EMAIL_ADDRESS.matcher(et_email.text.toString().trim()).matches() -> {
                et_email.error = "Please enter a valid email address"
                return false
            }
        }
        return true
    }

    private fun isPasswordValid(): Boolean{
        return when {
            et_password.text.toString().isEmpty() -> {
                et_password.error = "Password required"
                false
            }
            et_confPassword.text.toString().isEmpty() -> {
                et_confPassword.error = "Password required"
                false
            }
            et_password.text.toString() != et_confPassword.text.toString() -> {
                et_confPassword.error = "Password mismatched"
                false
            }
            else -> true
        }
    }

    private fun isValidWebsite(): Boolean{
        if (!URLUtil.isValidUrl(et_website.text.toString()) && !Patterns.WEB_URL.matcher(et_website.text.toString()).matches()){
            et_website.error = "Enter valid Website"
            return false
        }
        return true
    }

    private fun isImageUrlEmpty(): Boolean{
        if (et_phone.text.toString().isEmpty()){
            et_imageUrl.error = "Enter image url"
            return false
        }
        return true
    }

    private fun isGenderSelected(): Boolean{
        if (!rb_male.isChecked && !rb_female.isChecked){
            rb_female.error = "Enter image url"
            return false
        }
        return true
    }

}