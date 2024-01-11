package com.gity.foodbank.ui.fragment.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gity.foodbank.data.model.DataItem
import com.gity.foodbank.data.model.ListBoothResponse
import com.gity.foodbank.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _listBoothItems = MutableLiveData<List<DataItem>>()
    val listBoothItems: LiveData<List<DataItem>> get() = _listBoothItems

    private val _error = MutableLiveData<String>()

    fun fetchPopularItems() {
        viewModelScope.launch {
            try {
                val response = repository.getListBooth()
                if (response.isSuccessful) {
                    _listBoothItems.value = response.body()
                } else {
                    _error.value = "Error : ${response.code()} - ${response.message()}"
                }
            } catch (e: Exception) {
                _error.value = "Exception: ${e.message}"
            }
        }
    }

}