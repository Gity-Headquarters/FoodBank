package com.gity.foodbank.data.remote.retrofit.service

import com.gity.foodbank.data.model.DataItem
import com.gity.foodbank.data.model.ListBoothResponse
import com.gity.foodbank.data.model.LoginResponse
import com.gity.foodbank.data.model.LoginResponseDicoding
import com.gity.foodbank.data.model.LoginResponseDicodingResult
import com.gity.foodbank.data.model.RegisterResponse
import com.gity.foodbank.data.model.RegisterResponseDicoding
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Service {

    @FormUrlEncoded
    @POST("auth/login")
    suspend fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<LoginResponse>

    @FormUrlEncoded
    @POST("auth/register")
    suspend fun postRegister(
        @Field("nik") nik: String,
        @Field("username") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<RegisterResponse>

    @GET("booth")
    suspend fun getListBooth(): Response<List<DataItem>>

}