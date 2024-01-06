package com.gity.foodbank.ui.activity.register

import androidx.lifecycle.ViewModel
import com.gity.foodbank.data.model.RegisterResponseDicoding
import com.gity.foodbank.repository.Repository
import retrofit2.Response

class RegisterViewModel(private val repository: Repository) : ViewModel() {

    suspend fun register(
        name: String,
        email: String,
        password: String
    ): Response<RegisterResponseDicoding> {
        return repository.registerAuth(name, email, password)
    }

}