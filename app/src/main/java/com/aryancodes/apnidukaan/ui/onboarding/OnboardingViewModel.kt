package com.aryancodes.apnidukaan.ui.onboarding

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.aryancodes.apnidukaan.repository.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class OnboardingViewModel(private val dataStoreRepository: DataStoreRepository) : ViewModel() {
    suspend fun saveData(key: Preferences.Key<String>, value: String){
        dataStoreRepository.saveData(key, value)
    }

    fun loadData(key: Preferences.Key<String>) : LiveData<String>{
        return dataStoreRepository.loadData(key).asLiveData()
    }

}