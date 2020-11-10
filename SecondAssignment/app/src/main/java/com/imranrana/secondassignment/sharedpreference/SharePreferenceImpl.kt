package com.imranrana.secondassignment.sharedpreference

import android.content.Context
import android.content.SharedPreferences

class SharePreferenceImpl(context: Context): SharedPreference {

    private val preferences: SharedPreferences = context.getSharedPreferences("userData",Context.MODE_PRIVATE)
    private val editor = preferences.edit()

    override fun getString(key: String): String? {
        return preferences.getString(key,null)
    }

    override fun setString(key: String, value: String) {
        editor.putString(key,value)
        editor.apply()
    }

    override fun getInt(key: String): Int? {
        return preferences.getInt(key,-1)
    }

    override fun setInt(key: String, value: Int) {
        editor.putInt(key,value)
        editor.apply()
    }

    override fun getLong(key: String): Long? {
        return preferences.getLong(key,-1)
    }

    override fun setLong(key: String, value: Long) {
        editor.putLong(key,value)
        editor.apply()
    }

    override fun getFloat(key: String): Float? {
        return preferences.getFloat(key, -1.0f)
    }

    override fun setFloat(key: String, value: Float) {
        editor.putFloat(key,value)
        editor.apply()
    }

    override fun getBoolean(key: String): Boolean? {
        return preferences.getBoolean(key,false)
    }

    override fun setBoolean(key: String, value: Boolean) {
        editor.putBoolean(key,value)
        editor.apply()
    }

    override fun clearData() {
        editor.clear().apply()
    }
}