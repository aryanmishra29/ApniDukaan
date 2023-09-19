package com.aryancodes.apnidukaan.ui.onboarding

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.preferencesOf
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.databinding.FragmentLanguageBinding
import com.aryancodes.apnidukaan.databinding.FragmentUserTypeBinding
import com.aryancodes.apnidukaan.repository.DataStoreRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

private val Context.dataStore by preferencesDataStore(
    name = "userData"
)
class UserTypeFragment : Fragment() {
    private var _binding: FragmentUserTypeBinding? = null
    private val binding get() = _binding!!

    private lateinit var dataStoreRepository: DataStoreRepository
    private lateinit var userTypeCustomerCard : CardView
    private lateinit var userTypeBusinessCard : CardView
    private val userTypeKey = stringPreferencesKey("userType")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dataStoreRepository = DataStoreRepository(requireContext().dataStore)
        val onboardingViewModel : OnboardingViewModel by viewModels<OnboardingViewModel> {
            viewModelFactory {
                OnboardingViewModel(dataStoreRepository)
            }
        }

        _binding = FragmentUserTypeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        userTypeBusinessCard = binding.userTypeBusinessCard
        userTypeCustomerCard = binding.userTypeCustomerCard

        userTypeBusinessCard.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                onboardingViewModel.saveData(userTypeKey, "BUSINESS")
            }
            requireActivity().supportFragmentManager.commit {
                replace(R.id.onboarding_fragment_container, BusinessOnboardingFragment())
            }
        }

        userTypeCustomerCard.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                onboardingViewModel.saveData(userTypeKey, "CUSTOMER")
            }
            requireActivity().supportFragmentManager.commit {
                replace(R.id.onboarding_fragment_container, CustomerOnboardingFragment())
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
