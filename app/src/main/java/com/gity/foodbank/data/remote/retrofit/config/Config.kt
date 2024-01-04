package com.gity.foodbank.data.remote.retrofit.config

import com.gity.foodbank.data.remote.retrofit.service.Service
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Config {
    companion object {
        fun getApiService(): Service {
            val httpLoggingInterceptor1 = HttpLoggingInterceptor()
            val httpLoggingInterceptor = httpLoggingInterceptor1.apply {
                httpLoggingInterceptor1.level = HttpLoggingInterceptor.Level.BODY
            }
            val authInterceptor = Interceptor { chain ->
                val req = chain.request()
                val requestHeaders = req.newBuilder()
                    .build()
                chain.proceed(requestHeaders)
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(authInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://4009-103-105-34-98.ngrok-free.app/api/v1/auth/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(Service::class.java)
        }
    }
}