package com.aryancodes.apnidukaan.ui.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.databinding.FragmentUserTypeBinding
import com.aryancodes.apnidukaan.repository.DataStoreRepository
import com.aryancodes.apnidukaan.util.AndroidUtil
import com.aryancodes.apnidukaan.util.DatastoreKeys.userTypeKey
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UserTypeFragment : Fragment() {
    private var _binding: FragmentUserTypeBinding? = null
    private val binding get() = _binding!!

    private lateinit var dataStoreRepository: DataStoreRepository
    private lateinit var userTypeCustomerCard : CardView
    private lateinit var userTypeBusinessCard : CardView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataStoreRepository = DataStoreRepository(requireContext())
        val onboardingViewModel = ViewModelProvider(this, OnboardingViewModelFactory(dataStoreRepository))[OnboardingViewModel::class.java]

        _binding = FragmentUserTypeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        userTypeBusinessCard = binding.userTypeBusinessCard
        userTypeCustomerCard = binding.userTypeCustomerCard

        userTypeBusinessCard.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                onboardingViewModel.saveData(userTypeKey, "BUSINESS")
            }
            AndroidUtil.replaceFragment(requireActivity() as AppCompatActivity,R.id.onboarding_fragment_container, BusinessOnboardingFragment())
        }

        userTypeCustomerCard.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                onboardingViewModel.saveData(userTypeKey, "CUSTOMER")
            }
            AndroidUtil.replaceFragment(requireActivity() as AppCompatActivity, R.id.onboarding_fragment_container, CustomerOnboardingFragment())
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
