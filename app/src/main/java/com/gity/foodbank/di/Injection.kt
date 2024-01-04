package com.gity.foodbank.di

import com.gity.foodbank.data.remote.retrofit.config.Config
import com.gity.foodbank.repository.Repository

object Injection {
    fun provideRepository(): Repository {
        val apiService = Config.getApiService()
        return Repository(apiService)
    }
}