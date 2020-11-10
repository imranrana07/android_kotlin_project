package com.imranrana.secondassignment.data

import android.content.Context
import com.imranrana.secondassignment.sharedpreference.SharePreferenceImpl
import com.imranrana.secondassignment.sharedpreference.SharedPreference

class MainActivityModelImpl(context: Context): MainActivityModel {
    private val sharedPreference = SharePreferenceImpl(context = context)
    override fun getEmail(): String? {
        return sharedPreference.getString(SharedPreference.EMAIL)
    }

    override fun setEmail(email: String) {
        sharedPreference.setString(key = SharedPreference.EMAIL,value = email)
    }

    override fun getPassword(): String? {
        return sharedPreference.getString(SharedPreference.PASSWORD)
    }

    override fun setPassword(password: String) {
        sharedPreference.setString(SharedPreference.PASSWORD,password)
    }

    override fun getLoginStatus(): Boolean? {
        return sharedPreference.getBoolean(SharedPreference.LOGGED_IN)
    }

    override fun setLoginStatus(isLoggedIn: Boolean) {
        sharedPreference.setBoolean(SharedPreference.LOGGED_IN,isLoggedIn)
    }

}