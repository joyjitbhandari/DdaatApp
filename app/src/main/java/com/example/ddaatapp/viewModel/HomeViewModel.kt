package com.example.ddaatapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.model.responseDatamodel.BlogDetails
import com.example.ddaatapp.model.responseDatamodel.BlogListResponse
import com.example.ddaatapp.network.ApiService
import com.example.ddaatapp.model.responseDatamodel.SubscriptionListResponse
import com.flynaut.healthtag.util.Event
import kotlinx.coroutines.launch

class HomeViewModel(val apiService: ApiService) : ViewModel() {

    private val _toastMsg: MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg: LiveData<Event<String>> get() = _toastMsg


    private val _allBlogResponse = MutableLiveData<BlogListResponse>()
    val allBlogResponse : MutableLiveData< BlogListResponse> get() = _allBlogResponse

    private val _blogDetailsResponse = MutableLiveData<BlogDetails>()
    val blogDetailsResponse: MutableLiveData<BlogDetails> get() = _blogDetailsResponse



    fun getAllBlog() {
        viewModelScope.launch {
            try {
                val response = apiService.getBlogList()
                if (response.isSuccessful)
                    _allBlogResponse.value = response.body()
                else
                    _toastMsg.postValue(Event("Something Went Wrong"))
            } catch (e: Exception) {
                _toastMsg.postValue(Event("server failure try again" ))
                Log.d("error", "getSubscriptionList: ${e.printStackTrace()}")
            }
        }
    }

    fun getBolgDetails(field: Map<String, Int>) {
        viewModelScope.launch {
            try {
                val response = apiService.getBlogDetail(field)
                if (response.isSuccessful)
                    _blogDetailsResponse.value = response.body()
                else
                    _toastMsg.postValue(Event("Something Went Wrong"))
            } catch (e: Exception) {
                _toastMsg.postValue(Event("server failure try again" ))
                Log.d("error", "getSubscriptionList: ${e.printStackTrace()}")
            }
        }
    }


}
