package com.gity.foodbank.data.remote.retrofit.config

import com.gity.foodbank.data.remote.retrofit.service.Service
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Config {
    companion object {

        const val BASE_URL_DICODING = "https://story-api.dicoding.dev/v1/"
        const val BASE_URL_FOODBANK = "https://61e7-103-105-34-73.ngrok-free.app/api/v1/auth/"
        const val BASE_URL_FOODBANK2 = "https://6de9-103-105-33-73.ngrok-free.app/api/v1/auth/"
        const val BASE_URL_FOODBANKTANAHKU = "https://6d2c-103-105-34-73.ngrok-free.app/auth/"

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
                .baseUrl(BASE_URL_DICODING)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(Service::class.java)
        }
    }
}