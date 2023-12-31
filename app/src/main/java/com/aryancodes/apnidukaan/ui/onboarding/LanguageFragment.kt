package com.aryancodes.apnidukaan.ui.onboarding

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import com.aryancodes.apnidukaan.databinding.FragmentLanguageBinding
import com.aryancodes.apnidukaan.repository.DataStoreRepository

class LanguageFragment : Fragment() {
    private lateinit var dataStoreRepository: DataStoreRepository
    private var _binding: FragmentLanguageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        dataStoreRepository = DataStoreRepository(requireContext())
        val onboardingViewModel = ViewModelProvider(this, OnboardingViewModelFactory(dataStoreRepository))[OnboardingViewModel::class.java]

        _binding = FragmentLanguageBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

