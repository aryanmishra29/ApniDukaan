package com.aryancodes.apnidukaan.ui.authentication

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aryancodes.apnidukaan.repository.AuthRepository
import com.aryancodes.apnidukaan.repository.BusinessOwnerRepository
import com.aryancodes.apnidukaan.repository.CustomerRepository
import com.aryancodes.apnidukaan.repository.DataStoreRepository

class AuthenticationViewModelFactory(
    private val dataStoreRepository: DataStoreRepository,
    private val authRepository: AuthRepository,
    private val customerRepository: CustomerRepository,
    private val businessOwnerRepository: BusinessOwnerRepository,
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AuthenticationViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AuthenticationViewModel(
                dataStoreRepository,
                authRepository,
                customerRepository,
                businessOwnerRepository,
                context
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}