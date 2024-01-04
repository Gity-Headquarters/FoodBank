package com.gity.foodbank.ui.activity.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gity.foodbank.data.model.LoginResponse
import com.gity.foodbank.repository.Repository
import retrofit2.Response

class LoginViewModel(private val repository: Repository) : ViewModel() {

    private val _loginResutl = MutableLiveData<LoginResponse?>()
    val loginResult: LiveData<LoginResponse?> get() = _loginResutl

    suspend fun login(email: String, password: String): Response<LoginResponse> {
        return repository.loginAuth(email, password)
    }

}

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
