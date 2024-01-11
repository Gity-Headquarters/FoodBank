package com.gity.foodbank.repository


import android.util.Log
import com.gity.foodbank.data.model.LoginResponse
import com.gity.foodbank.data.model.LoginResponseDicoding
import com.gity.foodbank.data.model.RegisterResponse
import com.gity.foodbank.data.model.RegisterResponseDicoding
import com.gity.foodbank.data.remote.retrofit.service.Service
import retrofit2.Response

class Repository(private val apiService: Service) {

    suspend fun loginAuth(email: String, password: String): Response<LoginResponse> {
        return try {
            val response = apiService.postLogin(email, password)
            if (response.isSuccessful) {
                Response.success(response.body())
            } else {
                throw Exception(response.code().toString())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun registerAuth(
        nik: String,
        username: String,
        email: String,
        password: String,
    ): Response<RegisterResponse> {
        return try {
            val response = apiService.postRegister(nik, username, email, password)
            if (response.isSuccessful) {
                Response.success(response.body())
            } else {
                throw Exception(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }


}