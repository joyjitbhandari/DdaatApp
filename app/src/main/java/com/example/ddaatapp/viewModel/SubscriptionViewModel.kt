package com.example.ddaatapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.network.ApiService
import com.example.ddaatapp.model.responseDatamodel.SubscriptionListResponse
import com.flynaut.healthtag.util.Event
import kotlinx.coroutines.launch

class SubscriptionViewModel(val apiService: ApiService) : ViewModel() {

    private val _toastMsg: MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg: LiveData<Event<String>> get() = _toastMsg

    private val _apiResponse = MutableLiveData<SubscriptionListResponse>()
    val apiResponse: MutableLiveData<SubscriptionListResponse> get() = _apiResponse


    fun getSubscriptionList() {
        viewModelScope.launch {
            try {
                val response = apiService.getSubscriptionList()
                if (response.isSuccessful)
                    _apiResponse.value = response.body()
                else
                    _toastMsg.postValue(Event("Something Went Wrong"))
            } catch (e: Exception) {
                _toastMsg.postValue(Event("server failure try again" ))
                Log.d("error", "getSubscriptionList: ${e.printStackTrace()}")
            }
        }
    }

}
