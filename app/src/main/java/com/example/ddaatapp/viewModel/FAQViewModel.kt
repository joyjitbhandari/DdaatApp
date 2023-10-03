package com.example.ddaatapp.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.model.responseDatamodel.FaqListResponse
import com.example.ddaatapp.network.ApiService
import com.flynaut.healthtag.util.Event
import kotlinx.coroutines.launch

class FAQViewModel(val apiService: ApiService):ViewModel() {
    private val _toastMsg : MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg : MutableLiveData<Event<String>> = _toastMsg

    private val _apiResponse : MutableLiveData<FaqListResponse> = MutableLiveData()
    val apiResponse : MutableLiveData<FaqListResponse> = _apiResponse

    fun getFaq(){
        viewModelScope.launch {
            try {
                val response = apiService.getFaqs()
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