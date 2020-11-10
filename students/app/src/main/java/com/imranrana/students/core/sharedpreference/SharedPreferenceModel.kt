package com.imranrana.students.core.sharedpreference

interface SharedPreferenceModel {

    companion object{
        const val TOKEN = "token"
    }

    fun saveString(key: String,value: String)
    fun getString(key: String): String?
    fun saveInt(key: String,value: Int)
    fun getInt(key: String): Int
    fun saveFloat(key: String,value: Float)
    fun getFloat(key: String): Float
    fun saveBoolean(key: String, value: Boolean)
    fun getBoolean(key: String): Boolean
    fun setLong(key : String, value : Long)
    fun getLong(key : String) : Long
    fun clearData()
}