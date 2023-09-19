package com.aryancodes.apnidukaan.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.commit
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.databinding.ActivityOnboardingBinding
import com.aryancodes.apnidukaan.ui.business.BusinessMainActivity
import com.aryancodes.apnidukaan.ui.customer.CustomerMainActivity

class OnboardingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOnboardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        binding = ActivityOnboardingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startActivity(Intent(this, BusinessMainActivity::class.java))
        supportFragmentManager.commit {
            //replace(R.id.onboarding_fragment_container, BusinessOnboardingFragment())
        }
    }
}