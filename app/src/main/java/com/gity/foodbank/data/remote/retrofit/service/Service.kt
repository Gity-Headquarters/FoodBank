package com.gity.foodbank.data.remote.retrofit.service

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
import retrofit2.http.Header
import retrofit2.http.POST

interface Service {

    @FormUrlEncoded
    @POST("login")
    suspend fun postLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<LoginResponseDicoding>

    @FormUrlEncoded
    @POST("register")
    suspend fun postRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<RegisterResponse>

}