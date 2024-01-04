package com.gity.foodbank.repository


import com.gity.foodbank.data.model.LoginResponse
import com.gity.foodbank.data.remote.retrofit.service.Service
import retrofit2.Response

class Repository(private val apiService: Service) {

    suspend fun loginAuth(email: String, password: String): Response<LoginResponse> {
        return try {
            val response = apiService.postLogin(email, password)
            val code = apiService.postLogin(email, password).code()
            if (response.isSuccessful) {
                Response.success(response.body())
            } else {
                Response.error(code, response.errorBody()!!)
            }
        } catch (e: Exception) {
            throw e
        }
    }


}