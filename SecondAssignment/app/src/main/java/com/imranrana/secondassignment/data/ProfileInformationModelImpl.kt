package com.imranrana.secondassignment.data

import android.content.Context
import com.imranrana.secondassignment.sharedpreference.SharePreferenceImpl
import com.imranrana.secondassignment.sharedpreference.SharedPreference

class ProfileInformationModelImpl(context: Context): ProfileInformationModel {
    private val preference = SharePreferenceImpl(context)

    override fun getName(): String? {
        return preference.getString(SharedPreference.NAME)
    }

    override fun setName(name: String) {
        preference.setString(SharedPreference.NAME,name)
    }

    override fun getAge(): Int? {
        return preference.getInt(SharedPreference.AGE)
    }

    override fun setAge(age: Int) {
        preference.setInt(SharedPreference.AGE,age)
    }

    override fun getWeight(): Float? {
        return preference.getFloat(SharedPreference.WEIGHT)
    }

    override fun setWeight(weight: Float) {
        preference.setFloat(SharedPreference.WEIGHT,weight)
    }

    override fun getGender(): String? {
        return preference.getString(SharedPreference.GENDER)
    }

    override fun setGender(gender: String) {
        preference.setString(SharedPreference.GENDER,gender)
    }

    override fun isNotificationEnabled(): Boolean? {
        return  preference.getBoolean(SharedPreference.NOTIFICATION)
    }

    override fun setNotification(notification: Boolean) {
        preference.setBoolean(SharedPreference.NOTIFICATION,notification)
    }

    override fun getPhone(): Long? {
        return preference.getLong(SharedPreference.PHONE)
    }

    override fun setPhone(phone: Long) {
        preference.setLong(SharedPreference.PHONE,phone)
    }

    override fun getEmail(): String? {
        return preference.getString(SharedPreference.EMAIL)
    }

    override fun setEmail(email: String) {
        preference.setString(SharedPreference.EMAIL,email)
    }

    override fun getPassword(): String? {
        return preference.getString(SharedPreference.PASSWORD)
    }

    override fun setPassword(password: String) {
        preference.setString(SharedPreference.PASSWORD,password)
    }

    override fun getWebsite(): String? {
        return preference.getString(SharedPreference.WEBSITE)
    }

    override fun setWebsite(website: String) {
        preference.setString(SharedPreference.WEBSITE,website)
    }

    override fun getImageUrl(): String? {
        return preference.getString(SharedPreference.IMAGE_URL)
    }

    override fun setImageUrl(imageUrl: String) {
        preference.setString(SharedPreference.IMAGE_URL,imageUrl)
    }

    override fun clearData() {
        preference.clearData()
    }
}