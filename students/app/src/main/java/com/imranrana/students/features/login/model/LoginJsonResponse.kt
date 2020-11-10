package com.imranrana.students.features.login.model

data class LoginJsonResponse(
    val message: String,
    val status: Boolean,
    val token: String
)