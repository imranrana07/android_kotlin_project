package com.imranrana.students.core.sharedpreference

import android.content.Context
import com.imranrana.students.core.Utils

class SharedPreferenceModelImpl(private val context: Context): SharedPreferenceModel {
    private val sharedPreferenceInstance = context.getSharedPreferences(Utils.sharedPreference,Context.MODE_PRIVATE)
    private val editor = sharedPreferenceInstance.edit()
    override fun saveString(key: String,value: String) {
        editor.putString(key,value).apply()
    }

    override fun getString(key: String): String? {
        return sharedPreferenceInstance.getString(key,null)
    }

    override fun saveInt(key: String, value: Int) {
        editor.putInt(key,value).apply()
    }

    override fun getInt(key: String): Int {
        return sharedPreferenceInstance.getInt(key,-1)
    }

    override fun saveFloat(key: String, value: Float) {
        editor.putFloat(key,value).apply()
    }

    override fun getFloat(key: String): Float {
        return sharedPreferenceInstance.getFloat(key,-1f)
    }

    override fun saveBoolean(key: String, value: Boolean) {
        editor.putBoolean(key,value).apply()
    }

    override fun getBoolean(key: String): Boolean {
        return sharedPreferenceInstance.getBoolean(key,false)
    }

    override fun setLong(key: String, value: Long) {
        editor.putLong(key,value).apply()
    }

    override fun getLong(key: String): Long {
        return sharedPreferenceInstance.getLong(key,-1)
    }

    override fun clearData() {
        editor.clear().apply()
    }
}