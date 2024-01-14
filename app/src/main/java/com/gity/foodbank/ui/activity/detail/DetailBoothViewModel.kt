package com.gity.foodbank.ui.activity.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gity.foodbank.data.model.DataItem
import com.gity.foodbank.repository.Repository
import kotlinx.coroutines.launch

class DetailBoothViewModel(private val repository: Repository) : ViewModel() {

    private val _boothDetail = repository.boothDetail
    val boothDetail: LiveData<DataItem> get() = _boothDetail

    fun getBoothDetail(guid: String) {
        viewModelScope.launch {
            repository.getBoothDetail(guid)
        }
    }

}