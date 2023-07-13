package com.example.ddaatapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ddaatapp.network.ApiService
import com.example.ddaatapp.model.requestDatamodel.UpdateProfileRequest
import com.example.ddaatapp.model.responseDatamodel.UpdateProfileResponse
import com.flynaut.healthtag.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProfileViewModel(val apiService: ApiService) : ViewModel() {

    private val _toastMsg: MutableLiveData<Event<String>> = MutableLiveData()
    val toastMsg: LiveData<Event<String>> get() = _toastMsg


    //Update profile
    private val update_profile_data = MutableLiveData<com.example.ddaatapp.model.responseDatamodel.UpdateProfileResponse?>()
    val updateProfileResponse: MutableLiveData<com.example.ddaatapp.model.responseDatamodel.UpdateProfileResponse?> = update_profile_data



    //Update Profile
    fun updateProfile(updateProfileRequest: com.example.ddaatapp.model.requestDatamodel.UpdateProfileRequest) {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                apiService.updateProfile(updateProfileRequest)
            }
            if (response.isSuccessful) {
                update_profile_data.value = response.body()
            } else
                _toastMsg.postValue(Event(response.message().toString() ?: "Something Went Wrong"))

        }
    }


}
