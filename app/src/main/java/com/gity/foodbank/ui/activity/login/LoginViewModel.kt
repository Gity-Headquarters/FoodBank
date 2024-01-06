package com.gity.foodbank.ui.activity.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gity.foodbank.data.model.LoginResponseDicoding
import com.gity.foodbank.data.model.LoginResponseDicodingResult
import com.gity.foodbank.repository.Repository
import retrofit2.Response

class LoginViewModel(private val repository: Repository) : ViewModel() {

    suspend fun login(email: String, password: String): Response<LoginResponseDicoding> {
        return repository.loginAuth(email, password)
    }

}

