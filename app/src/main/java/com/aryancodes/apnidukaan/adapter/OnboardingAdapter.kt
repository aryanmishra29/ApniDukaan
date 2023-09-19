package com.aryancodes.apnidukaan.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.aryancodes.apnidukaan.ui.onboarding.OnboardingType
import com.aryancodes.apnidukaan.ui.onboarding.OnboardingViewPagerFragment

class OnboardingAdapter(activity: FragmentActivity, private val itemsCount : Int, private val type: OnboardingType) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return itemsCount
    }

    override fun createFragment(position: Int): Fragment {
        return OnboardingViewPagerFragment.getInstance(position, type)
    }
}