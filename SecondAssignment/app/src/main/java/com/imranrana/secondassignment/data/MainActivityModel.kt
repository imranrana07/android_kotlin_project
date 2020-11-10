package com.imranrana.secondassignment.data

interface MainActivityModel {
    fun getEmail(): String?
    fun setEmail(email: String)
    fun getPassword(): String?
    fun setPassword(password: String)
    fun getLoginStatus(): Boolean?
    fun setLoginStatus(isLoggedIn: Boolean)
}