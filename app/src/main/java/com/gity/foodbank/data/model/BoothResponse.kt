package com.gity.foodbank.data.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class BoothResponse(

    @field:SerializedName("code")
	val code: Int? = null,

    @field:SerializedName("data")
	val data: List<DataItem>,

    @field:SerializedName("status")
	val status: String? = null
) : Parcelable

@Parcelize
data class DataItem(

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
