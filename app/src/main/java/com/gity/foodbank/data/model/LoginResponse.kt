package com.gity.foodbank.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("data")
    val data: Data? = null,

    @field:SerializedName("meta")
    val meta: Meta? = null,

    @field:SerializedName("token")
    val token: String
)

data class Data(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("email")
    val email: String
)

data class Meta(

    @field:SerializedName("code")
    val code: Int,

    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("status")
    val status: String
)
