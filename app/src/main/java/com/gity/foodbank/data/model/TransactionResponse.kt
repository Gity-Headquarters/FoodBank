package com.gity.foodbank.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransactionResponse(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val dataTranscation: DataTranscation? = null,

    @field:SerializedName("status")
    val status: String? = null
) : Parcelable

@Parcelize
data class Transaction(

    @field:SerializedName("booth_id")
    val boothId: String? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("user_id")
    val userId: String? = null,

    @field:SerializedName("total_food")
    val totalFood: Int? = null,

    @field:SerializedName("guid")
    val guid: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null
) : Parcelable

@Parcelize
data class User(

    @field:SerializedName("nik")
    val nik: String? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("password")
    val password: String? = null,

    @field:SerializedName("role")
    val role: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("image_profile")
    val imageProfile: String? = null,

    @field:SerializedName("guid")
    val guid: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("email")
    val email: String? = null,

    @field:SerializedName("username")
    val username: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null
) : Parcelable

@Parcelize
data class DataTranscation(

    @field:SerializedName("user")
    val user: User? = null,

    @field:SerializedName("transaction")
    val transaction: Transaction? = null,

    @field:SerializedName("booth")
    val booth: Booth? = null
) : Parcelable

@Parcelize
data class Booth(

    @field:SerializedName("image")
    val image: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("info_booth")
    val infoBooth: String? = null,

    @field:SerializedName("time_open")
    val timeOpen: String? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("time_close")
    val timeClose: String? = null,

    @field:SerializedName("food_total")
    val foodTotal: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("guid")
    val guid: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("status")
    val status: String? = null,

    @field:SerializedName("number_phone")
    val numberPhone: String? = null,

    @field:SerializedName("updatedAt")
    val updatedAt: String? = null
) : Parcelable
