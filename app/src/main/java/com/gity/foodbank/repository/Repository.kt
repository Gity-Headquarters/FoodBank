package com.gity.foodbank.repository


import com.gity.foodbank.data.model.LoginResponseDicoding
import com.gity.foodbank.data.model.RegisterResponseDicoding
import com.gity.foodbank.data.remote.retrofit.service.Service
import retrofit2.Response

class Repository(private val apiService: Service) {

    suspend fun loginAuth(email: String, password: String): Response<LoginResponseDicoding> {
        return try {
            val response = apiService.postLogin(email, password)
            if (response.isSuccessful) {
                Response.success(response.body())
            } else {
                throw Exception(response.message())
            }
        } catch (e: Exception) {
            throw e
        }
    }

    suspend fun registerAuth(
        name: String,
        email: String,
        password: String
    ): Response<RegisterResponseDicoding> {
        return try {
            val response = apiService.postRegister(name, email, password)
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