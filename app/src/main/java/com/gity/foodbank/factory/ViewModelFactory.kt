package com.gity.foodbank.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gity.foodbank.repository.Repository
import com.gity.foodbank.ui.activity.detail.DetailBoothViewModel
import com.gity.foodbank.ui.activity.login.LoginViewModel
import com.gity.foodbank.ui.activity.register.RegisterViewModel
import com.gity.foodbank.ui.fragment.home.HomeViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailBoothViewModel::class.java)) {
            return DetailBoothViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}