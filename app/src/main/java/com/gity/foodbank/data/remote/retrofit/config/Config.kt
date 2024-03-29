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
        private const val BASE_URL_FOODBANKONLINE = "https://backend-dot-food-bank-410807.et.r.appspot.com/"
        const val BASE_URL_FOODBANKTANAHKU = "https://6d2c-103-105-34-73.ngrok-free.app/auth/"

        fun getApiService(): Service {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL_FOODBANKONLINE)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(Service::class.java)
        }
    }
}