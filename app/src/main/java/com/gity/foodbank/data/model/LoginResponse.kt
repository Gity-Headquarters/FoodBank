package com.gity.foodbank.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoginResponse(

    @field:SerializedName("data")
    val data: DataLogin? = null,

    @field:SerializedName("meta")
    val meta: Meta? = null,

    @field:SerializedName("token")
    val token: String? = null
) : Parcelable

@Parcelize
data class DataLogin(

    @field:SerializedName("role")
    val role: String? = null,

    @field:SerializedName("image_profile")
    val imageProfile: String? = null,

    @field:SerializedName("guid")
    val guid: String? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("username")
    val username: String? = null
) : Parcelable

@Parcelize
data class Meta(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: String? = null
) : Parcelable
