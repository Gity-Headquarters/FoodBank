package com.gity.foodbank.data.model

import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @field:SerializedName("code")
    val code: Int,
    @field:SerializedName("status")
    val status: String,
    @field:SerializedName("data")
    val data: DataItem
)

data class DataItem(
    @field:SerializedName("error")
    val error: String
)
