package com.aryancodes.apnidukaan.ui.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.databinding.ActivityOnboardingBinding
import com.aryancodes.apnidukaan.repository.DataStoreRepository
import com.aryancodes.apnidukaan.ui.authentication.AuthenticationActivity
import com.aryancodes.apnidukaan.ui.business.BusinessMainActivity
import com.aryancodes.apnidukaan.ui.customer.CustomerMainActivity
import com.aryancodes.apnidukaan.util.AndroidUtil
import com.aryancodes.apnidukaan.util.DatastoreKeys.isLoggedInKey
import com.aryancodes.apnidukaan.util.DatastoreKeys.userTypeKey

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding
    private lateinit var dataStoreRepository: DataStoreRepository
    private lateinit var onboardingViewModel : OnboardingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        dataStoreRepository = DataStoreRepository(this)
        onboardingViewModel = ViewModelProvider(this, OnboardingViewModelFactory(dataStoreRepository))[OnboardingViewModel::class.java]
        setContentView(binding.root)
        onboardingViewModel.loadData(isLoggedInKey).observe(this){isLoggedIn->
            if(isLoggedIn == "YES"){
                onboardingViewModel.loadData(userTypeKey).observe(this){
                    if(it == "CUSTOMER"){
                        startActivity(Intent(this, CustomerMainActivity::class.java))
                        finish()
                    }
                    else if (it == "BUSINESS"){
                        startActivity(Intent(this, BusinessMainActivity::class.java))
                        finish()
                    }
                }
            }
            else if(isLoggedIn == "NO"){
                startActivity(Intent(this, AuthenticationActivity::class.java))
                finish()
            }

        }
        AndroidUtil.replaceFragment(this, R.id.onboarding_fragment_container, UserTypeFragment())

    }
}