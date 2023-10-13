package com.aryancodes.apnidukaan.ui.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.fragment.app.commit
import androidx.viewpager2.widget.ViewPager2
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.adapter.OnboardingAdapter
import com.aryancodes.apnidukaan.databinding.FragmentCustomerOnboardingBinding
import com.aryancodes.apnidukaan.ui.authentication.AuthenticationActivity
import com.aryancodes.apnidukaan.ui.customer.CustomerMainActivity

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
        binding.btnCustomerOnboardingStart.isInvisible = true
        binding.btnCustomerOnboardingNext.setOnClickListener {
            if(binding.viewpagerCustomerOnboarding.currentItem == 2){
                binding.viewpagerCustomerOnboarding.setCurrentItem((binding.viewpagerCustomerOnboarding.currentItem+1), true)
                binding.btnCustomerOnboardingStart.isInvisible = false
                binding.btnCustomerOnboardingNext.isInvisible = true
                binding.btnCustomerOnboardingSkip.isInvisible = true
            }
            else{
                binding.viewpagerCustomerOnboarding.setCurrentItem((binding.viewpagerCustomerOnboarding.currentItem+1), true)
            }
        }
        binding.btnCustomerOnboardingSkip.setOnClickListener {
            startActivity(Intent(context, AuthenticationActivity::class.java))
        }
        binding.btnCustomerOnboardingStart.setOnClickListener {
            startActivity(Intent(context, AuthenticationActivity::class.java))
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
