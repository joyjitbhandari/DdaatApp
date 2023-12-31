package com.example.ddaatapp.viewModel

import androidx.lifecycle.ViewModelProvider

import androidx.lifecycle.ViewModel
import com.example.ddaatapp.network.ApiService

class ViewModelFactory(private val apiService: ApiService) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        return when{
            modelClass.isAssignableFrom(SignUPViewModel::class.java) -> SignUPViewModel(apiService) as T

            modelClass.isAssignableFrom(ProfileViewModel::class.java) -> ProfileViewModel(apiService) as T

            modelClass.isAssignableFrom(LogInViewModel::class.java) -> LogInViewModel(apiService) as T

            modelClass.isAssignableFrom(OTPViewModel::class.java) -> OTPViewModel(apiService) as T

            modelClass.isAssignableFrom(PasswordViewModel::class.java) -> PasswordViewModel(apiService) as T

            modelClass.isAssignableFrom(SubscriptionViewModel::class.java) -> SubscriptionViewModel(apiService) as T

            modelClass.isAssignableFrom(HomeViewModel::class.java) -> HomeViewModel(apiService) as T

            modelClass.isAssignableFrom(CategoryViewModel::class.java)-> CategoryViewModel(apiService) as T

            modelClass.isAssignableFrom(FAQViewModel::class.java)-> FAQViewModel(apiService) as T

            else -> throw IllegalArgumentException("ViewModel Not Found")
        }

    }


}