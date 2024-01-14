package com.gity.foodbank.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gity.foodbank.data.model.DataItem
import com.gity.foodbank.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _booths = repository.booths
    val booths: LiveData<List<DataItem>> get() = _booths

    fun getBooths() {
        viewModelScope.launch {
            repository.getBooths()
        }
    }

}