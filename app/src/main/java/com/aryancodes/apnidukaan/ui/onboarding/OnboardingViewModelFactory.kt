package com.aryancodes.apnidukaan.ui.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aryancodes.apnidukaan.repository.DataStoreRepository

class OnboardingViewModelFactory(private val dataStoreRepository: DataStoreRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OnboardingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return OnboardingViewModel(dataStoreRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
