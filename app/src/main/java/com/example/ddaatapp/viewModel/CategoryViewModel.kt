package com.example.ddaatapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.model.responseDatamodel.CategoryList
import com.example.ddaatapp.network.ApiService
import com.flynaut.healthtag.util.Event
import kotlinx.coroutines.launch

class CategoryViewModel(val apiService: ApiService):ViewModel() {

    private val _toastMsg : MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg : LiveData<Event<String>> get() =  _toastMsg

    private val _categoryResponse : MutableLiveData<CategoryList> = MutableLiveData()
    val categoryResponse : LiveData<CategoryList> = _categoryResponse

    fun getCategoryList(){
        viewModelScope.launch {
            try {
                val response = apiService.getCategory()
                if(response.isSuccessful)
                    _categoryResponse.postValue(response.body())
                else
                    _toastMsg.postValue(Event("Something Went Wrong"))
            } catch (e: Exception) {
                _toastMsg.postValue(Event("server failure try again" ))
                Log.d("error", "getSubscriptionList: ${e.printStackTrace()}")
            }
        }
    }
}