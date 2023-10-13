package com.aryancodes.apnidukaan.ui.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.databinding.ActivityAuthenticationBinding
import com.aryancodes.apnidukaan.repository.AuthRepository
import com.aryancodes.apnidukaan.repository.BusinessOwnerRepository
import com.aryancodes.apnidukaan.repository.CustomerRepository
import com.aryancodes.apnidukaan.repository.DataStoreRepository

class AuthenticationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthenticationBinding
    private lateinit var dataStoreRepository: DataStoreRepository
    private lateinit var customerRepository: CustomerRepository
    private lateinit var businessOwnerRepository: BusinessOwnerRepository
    private lateinit var authRepository: AuthRepository
    private lateinit var authenticationViewModel: AuthenticationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataStoreRepository = DataStoreRepository(this)
        customerRepository = CustomerRepository()
        businessOwnerRepository = BusinessOwnerRepository()
        authRepository = AuthRepository(this)

        authenticationViewModel = ViewModelProvider(this, AuthenticationViewModelFactory(
            dataStoreRepository, authRepository, customerRepository, businessOwnerRepository, this
        ))[AuthenticationViewModel::class.java]

    }

}