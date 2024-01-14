package com.gity.foodbank.ui.activity.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gity.foodbank.data.model.DetailBoothResponse
import com.gity.foodbank.repository.Repository
import kotlinx.coroutines.launch

class DetailBoothViewModel(private val repository: Repository) : ViewModel() {

    private val _boothDetail = MutableLiveData<DetailBoothResponse>()
    val boothDetail: LiveData<DetailBoothResponse> get() = _boothDetail

    fun getBoothDetail(guid: String) {
        viewModelScope.launch {
            try {
                _boothDetail.value = repository.getBoothDetail(guid)
            } catch (e: Exception) {
                throw e
            }
        }
    }

}