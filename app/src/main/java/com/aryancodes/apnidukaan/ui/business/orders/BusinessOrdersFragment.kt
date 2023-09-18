package com.aryancodes.apnidukaan.ui.business.orders

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.databinding.FragmentBusinessFeedBinding
import com.aryancodes.apnidukaan.databinding.FragmentBusinessOrdersBinding
import com.aryancodes.apnidukaan.ui.business.feed.BusinessFeedViewModel

class BusinessOrdersFragment : Fragment() {

    private var _binding: FragmentBusinessOrdersBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val businessOrdersViewModel =
            ViewModelProvider(this).get(BusinessOrdersViewModel::class.java)

        _binding = FragmentBusinessOrdersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        businessOrdersViewModel.text.observe(viewLifecycleOwner){
            binding.ordersText.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}