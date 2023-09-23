package com.aryancodes.apnidukaan.ui.onboarding

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aryancodes.apnidukaan.repository.DataStoreRepository

class OnboardingViewModel(private val dataStoreRepository: DataStoreRepository) : ViewModel() {
    suspend fun saveData(key: Preferences.Key<String>, value: String){
        dataStoreRepository.saveData(key, value)
    }
}