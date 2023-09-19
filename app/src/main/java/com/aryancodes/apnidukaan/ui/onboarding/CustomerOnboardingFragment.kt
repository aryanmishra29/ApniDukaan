package com.aryancodes.apnidukaan.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.adapter.OnboardingAdapter
import com.aryancodes.apnidukaan.databinding.FragmentCustomerOnboardingBinding

class CustomerOnboardingFragment : Fragment() {

    private var onBoardingPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            updateCircleMarker(binding, position)
        }
    }

    private fun updateCircleMarker(binding: FragmentCustomerOnboardingBinding, position: Int) {

    }

    private var _binding: FragmentCustomerOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCustomerOnboardingBinding.inflate(inflater, container, false)

        val numberOfScreens = resources.getStringArray(R.array.customer_on_boarding_titles).size
        val onBoardingAdapter = OnboardingAdapter(requireActivity(), numberOfScreens, OnboardingType.CUSTOMER)
        (activity as AppCompatActivity).supportActionBar?.hide()
        binding.viewpagerCustomerOnboarding.adapter = onBoardingAdapter
        binding.viewpagerCustomerOnboarding.registerOnPageChangeCallback(onBoardingPageChangeCallback)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
