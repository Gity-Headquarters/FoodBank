package com.gity.foodbank.data.model

data class LoginResponseDicoding(
    val error: Boolean?     = null,
    val message: String? = null,
    val loginResult: LoginResponseDicodingResult? = null
)

data class LoginResponseDicodingResult(
    val userId: String? = null,
    val name: String? = null,
    val token: String? = null
)
