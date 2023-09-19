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
import com.aryancodes.apnidukaan.databinding.FragmentBusinessOnboardingBinding

class BusinessOnboardingFragment : Fragment() {

    private var onBoardingPageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            updateCircleMarker(binding, position)
        }
    }

    private fun updateCircleMarker(binding: FragmentBusinessOnboardingBinding, position: Int) {

    }

    private var _binding: FragmentBusinessOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBusinessOnboardingBinding.inflate(inflater, container, false)

        val numberOfScreens = resources.getStringArray(R.array.business_on_boarding_titles).size
        val onBoardingAdapter = OnboardingAdapter(requireActivity(), numberOfScreens, OnboardingType.BUSINESS)
        (activity as AppCompatActivity).supportActionBar?.hide()
        binding.viewpagerBusinessOnboarding.adapter = onBoardingAdapter
        binding.viewpagerBusinessOnboarding.registerOnPageChangeCallback(onBoardingPageChangeCallback)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
