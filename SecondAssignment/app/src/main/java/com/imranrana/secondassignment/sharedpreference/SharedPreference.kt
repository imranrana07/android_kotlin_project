package com.imranrana.secondassignment.sharedpreference

interface SharedPreference {

    companion object{
        const val NAME = "name"
        const val PHONE = "phone"
        const val EMAIL = "email"
        const val PASSWORD = "password"
        const val WEBSITE = "website"
        const val IMAGE_URL = "imageUrl"
        const val LOGGED_IN = "loggedIn"
        const val AGE = "age"
        const val WEIGHT = "weight"
        const val GENDER = "gender"
        const val NOTIFICATION = "notification"
    }

    fun getString(key: String): String?
    fun setString(key: String, value: String)
    fun getInt(key : String) : Int?
    fun setInt(key : String, value : Int)
    fun getLong(key : String) : Long?
    fun setLong(key : String, value : Long)
    fun getFloat(key : String) : Float?
    fun setFloat(key : String, value : Float)
    fun getBoolean(key: String): Boolean?
    fun setBoolean(key: String,value: Boolean)
    fun clearData()

}