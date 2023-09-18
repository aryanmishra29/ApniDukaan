package com.aryancodes.apnidukaan.ui.business.feed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.databinding.FragmentBusinessFeedBinding
import com.aryancodes.apnidukaan.databinding.FragmentCustomerCartBinding
import com.aryancodes.apnidukaan.ui.customer.cart.CustomerCartViewModel

class BusinessFeedFragment : Fragment() {

    private var _binding: FragmentBusinessFeedBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val businessFeedViewModel =
            ViewModelProvider(this).get(BusinessFeedViewModel::class.java)

        _binding = FragmentBusinessFeedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        businessFeedViewModel.text.observe(viewLifecycleOwner){
            binding.feedText.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}