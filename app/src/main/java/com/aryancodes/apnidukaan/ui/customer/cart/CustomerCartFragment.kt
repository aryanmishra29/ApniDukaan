package com.aryancodes.apnidukaan.ui.customer.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aryancodes.apnidukaan.databinding.FragmentCustomerCartBinding

class CustomerCartFragment : Fragment() {

    private var _binding: FragmentCustomerCartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val customerCartViewModel =
            ViewModelProvider(this).get(CustomerCartViewModel::class.java)

        _binding = FragmentCustomerCartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        customerCartViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}