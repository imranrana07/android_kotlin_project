package com.imranrana.secondassignment.data

interface ProfileInformationModel {
    fun getName(): String?
    fun setName(name: String)
    fun getAge(): Int?
    fun setAge(age: Int)
    fun getWeight(): Float?
    fun setWeight(weight: Float)
    fun getGender() : String?
    fun setGender(gender : String)
    fun isNotificationEnabled() : Boolean?
    fun setNotification(notification : Boolean)
    fun getPhone(): Long?
    fun setPhone(phone: Long)
    fun getEmail(): String?
    fun setEmail(email: String)
    fun getPassword(): String?
    fun setPassword(password: String)
    fun getWebsite(): String?
    fun setWebsite(website: String)
    fun getImageUrl(): String?
    fun setImageUrl(imageUrl: String)
    fun clearData()
}