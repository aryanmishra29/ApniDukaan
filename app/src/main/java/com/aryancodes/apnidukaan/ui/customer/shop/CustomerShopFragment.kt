package com.aryancodes.apnidukaan.ui.customer.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aryancodes.apnidukaan.databinding.FragmentCustomerShopBinding

class CustomerShopFragment : Fragment() {

    private var _binding: FragmentCustomerShopBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val customerShopViewModel =
            ViewModelProvider(this).get(CustomerShopViewModel::class.java)

        _binding = FragmentCustomerShopBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        customerShopViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}