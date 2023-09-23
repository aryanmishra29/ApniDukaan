package com.aryancodes.apnidukaan.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.databinding.FragmentOnboardingViewPagerBinding


class OnboardingViewPagerFragment : Fragment() {

    companion object {
        private const val ARG_POSITION = "ARG_POSITION"
        private const val TYPE = "TYPE"

        fun getInstance(position: Int, type: OnboardingType) = OnboardingViewPagerFragment().apply {
            arguments = bundleOf(ARG_POSITION to position, TYPE to type)
        }
    }

    private lateinit var binding: FragmentOnboardingViewPagerBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentOnboardingViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val position = requireArguments().getInt(ARG_POSITION)
        val type = requireArguments().get(TYPE)
        val customerOnBoardingTitles = requireContext().resources.getStringArray(R.array.customer_on_boarding_titles)
        val customerOnBoardingTexts = requireContext().resources.getStringArray(R.array.customer_on_boarding_texts)
        val businessOnBoardingTitles = requireContext().resources.getStringArray(R.array.business_on_boarding_titles)
        val businessOnBoardingTexts = requireContext().resources.getStringArray(R.array.business_on_boarding_texts)
        when(type) {
            OnboardingType.CUSTOMER -> {
                val onBoardingImages = getOnBoardAssetsLocationCustomer()
                with(binding) {
                    onBoardingImage.setImageResource(onBoardingImages[position])
                    onBoardingTextTitle.text = customerOnBoardingTitles[position]
                    onBoardingTextMsg.text = customerOnBoardingTexts[position]
                }

            }
            OnboardingType.BUSINESS -> {
                val onBoardingImages = getOnBoardAssetsLocationBusiness()
                with(binding) {
                    onBoardingImage.setImageResource(onBoardingImages[position])
                    onBoardingTextTitle.text = businessOnBoardingTitles[position]
                    onBoardingTextMsg.text = businessOnBoardingTexts[position]
                }
            }
        }

    }

    private fun getOnBoardAssetsLocationCustomer(): List<Int> {
        val onBoardAssets: MutableList<Int> = ArrayList()
        onBoardAssets.add(R.drawable.customer_onboarding_1)
        onBoardAssets.add(R.drawable.customer_onboarding_2)
        onBoardAssets.add(R.drawable.customer_onboarding_3)
        onBoardAssets.add(R.drawable.customer_onboarding_4)
        return onBoardAssets
    }
    private fun getOnBoardAssetsLocationBusiness(): List<Int> {
        val onBoardAssets: MutableList<Int> = ArrayList()
        onBoardAssets.add(R.drawable.business_onboarding_1)
        onBoardAssets.add(R.drawable.business_onboarding_2)
        onBoardAssets.add(R.drawable.business_onboarding_3)
        onBoardAssets.add(R.drawable.business_onboarding_4)
        return onBoardAssets
    }
}

