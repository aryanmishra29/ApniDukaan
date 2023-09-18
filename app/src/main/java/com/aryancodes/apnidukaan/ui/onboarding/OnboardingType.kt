package com.aryancodes.apnidukaan.ui.onboarding

import java.io.Serializable

sealed class OnboardingType : Serializable {
    data object CUSTOMER : OnboardingType()
    data object BUSINESS : OnboardingType()
}