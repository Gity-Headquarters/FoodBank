package com.gity.foodbank.ui.activity.register

import androidx.lifecycle.ViewModel
import com.gity.foodbank.data.model.RegisterResponse
import com.gity.foodbank.data.model.RegisterResponseDicoding
import com.gity.foodbank.repository.Repository
import retrofit2.Response

class RegisterViewModel(private val repository: Repository) : ViewModel() {

    suspend fun register(
        nik: String,
        username: String,
        email: String,
        password: String,
    ): Response<RegisterResponse> {
        return repository.registerAuth(nik, username, email, password)
    }

}