package com.gity.foodbank.data.remote.retrofit.service

import com.gity.foodbank.data.model.BoothResponse
import com.gity.foodbank.data.model.DetailBoothResponse
import com.gity.foodbank.data.model.LoginResponse
import com.gity.foodbank.data.model.RegisterResponse
import com.gity.foodbank.data.model.TransactionResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

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

    @FormUrlEncoded
    @POST("transaction")
    suspend fun postTransaction(
        @Field("booth_id") boothId: String,
        @Field("user_id") userId: String
    ): Response<TransactionResponse>

    @GET("booth")
    suspend fun getBooths(): Response<BoothResponse>

    @GET("booth/{boothId}")
    suspend fun getBoothDetail(
        @Path("boothId") boothId: String
    ): DetailBoothResponse

}