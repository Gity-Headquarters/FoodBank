package com.gity.foodbank.repository


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gity.foodbank.data.model.DataItem
import com.gity.foodbank.data.model.DetailBoothResponse
import com.gity.foodbank.data.model.LoginResponse
import com.gity.foodbank.data.model.RegisterResponse
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

//    Get List of Booths
    private val _booths = MutableLiveData<List<DataItem>>()
    val booths: LiveData<List<DataItem>> get() = _booths
    suspend fun getBooths() {
        try {
            val response = apiService.getBooths()
            if (response.isSuccessful) {
                _booths.postValue(response.body()?.data ?: emptyList())
            } else {
                val code = response.code().toString()
                val message = response.message().toString()

                Log.d("HTTP INFORMATION", "Code : $code\n Message : $message")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

//    Get Detail Booths by Id
    suspend fun getBoothDetail(guid: String): DetailBoothResponse {
        return apiService.getBoothDetail(guid)
    }





}