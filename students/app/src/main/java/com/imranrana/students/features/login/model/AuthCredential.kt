package com.imranrana.students.features.login.model

import com.google.gson.annotations.SerializedName

data class AuthCredential (
        @SerializedName("user_id")
        var email: String,
        var password: String
)