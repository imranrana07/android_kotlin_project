package com.imranrana.secondassignment.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.imranrana.secondassignment.R
import com.imranrana.secondassignment.core.BaseActivity
import com.imranrana.secondassignment.data.ProfileInformationModelImpl
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : BaseActivity() {
    private lateinit var profileInformationModelImpl: ProfileInformationModelImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setActionBar("Profile",true)
        profileInformationModelImpl = ProfileInformationModelImpl(this)
        setValues()

        tv_websiteValue.setOnClickListener {
            val intent = Intent(this, WebviewActivity::class.java)
            intent.putExtra("url",tv_websiteValue.text.toString())
            startActivity(intent)
        }

        tv_passwordValue.setOnClickListener{
            updatePassword()
        }

        tv_passwordValueShowHide.setOnClickListener {
            if(tv_passwordValue.transformationMethod is PasswordTransformationMethod){
                tv_passwordValue.transformationMethod = null
            }else {
                tv_passwordValue.transformationMethod = PasswordTransformationMethod()
            }
        }

        btn_logout.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            profileInformationModelImpl.clearData()
        }

        if (profileInformationModelImpl.getImageUrl()!=null) {
            Glide.with(this)
                .load(profileInformationModelImpl.getImageUrl())
                .placeholder(R.drawable.flower)
//                .error(R.drawable.eye)
                .into(img_onlineImage)
        }
    }

    override fun onNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setValues(){
        tv_nameValue.text = profileInformationModelImpl.getName()
        tv_phoneValue.text = profileInformationModelImpl.getPhone().toString()
        tv_ageValue.text = profileInformationModelImpl.getAge().toString()
        tv_weightValue.text = profileInformationModelImpl.getWeight().toString()
        tv_emailValue.text = profileInformationModelImpl.getEmail()
        tv_passwordValue.text = profileInformationModelImpl.getPassword()
        tv_websiteValue.text = profileInformationModelImpl.getWebsite()
        if (profileInformationModelImpl.isNotificationEnabled()!! && profileInformationModelImpl.isNotificationEnabled() != null){
            tv_notificationValue.text = getString(R.string.enabled)
        }else{
            tv_notificationValue.text = getString(R.string.disabled)
        }
        tv_genderValue.text = profileInformationModelImpl.getGender()
    }

    @SuppressLint("InflateParams")
    private fun updatePassword(){
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.update_password,null)

        builder.setView(view)
        val oldPass = view.findViewById<EditText>(R.id.et_oldPass)
        val newPass = view.findViewById<EditText>(R.id.et_newPass)
        val confPass = view.findViewById<EditText>(R.id.et_confPass)
        val btnSubmit = view.findViewById<Button>(R.id.btn_submit)

        //ques - how to use widget out of the method/////////
        //ques - not able to read pref value /////////
        //ques - url validation//////
        btnSubmit.setOnClickListener {
            if (isCurrentPassword(oldPass.text.toString()) && isNewPasswordsMatched(newPass.text.toString(),confPass.text.toString())) {
                saveNewPass(newPass.text.toString())
            }else if(!isCurrentPassword(oldPass.text.toString())){
                oldPass.error = "Wrong current password "
            }else if (!isNewPasswordsMatched(newPass.text.toString(),confPass.text.toString())){
                confPass.error = "Password mismatch"
            }
        }
        builder.create().show()
    }

    private fun isCurrentPassword( password : String) : Boolean{
        return profileInformationModelImpl.getPassword() == password
    }

    private fun isNewPasswordsMatched(newPassword : String, confPass : String) : Boolean {
        return newPassword == confPass
    }

    private fun saveNewPass(newPass : String){
        profileInformationModelImpl.setPassword(newPass)
        Toast.makeText(this, "Password updated successfully", Toast.LENGTH_LONG).show()
//        sharedPreferences.edit().clear().apply()
//        startActivity(Intent(this, LoginActivity::class.java))
    }
}