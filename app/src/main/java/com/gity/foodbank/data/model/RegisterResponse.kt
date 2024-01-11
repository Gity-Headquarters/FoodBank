package com.gity.foodbank.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegisterResponse(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: DataRegister? = null,

    @field:SerializedName("status")
    val status: String? = null
) : Parcelable

@Parcelize
data class DataRegister(

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("username")
    val username: String? = null

) : Parcelable
