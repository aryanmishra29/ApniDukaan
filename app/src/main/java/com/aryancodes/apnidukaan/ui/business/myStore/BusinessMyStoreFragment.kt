package com.aryancodes.apnidukaan.ui.business.myStore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.databinding.FragmentBusinessFeedBinding
import com.aryancodes.apnidukaan.databinding.FragmentBusinessMyStoreBinding
import com.aryancodes.apnidukaan.ui.business.feed.BusinessFeedViewModel

class BusinessMyStoreFragment : Fragment() {

    private var _binding: FragmentBusinessMyStoreBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val businessMyStoreViewModel =
            ViewModelProvider(this).get(BusinessMyStoreViewModel::class.java)

        _binding = FragmentBusinessMyStoreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        businessMyStoreViewModel.text.observe(viewLifecycleOwner){
            binding.myStoreText.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}