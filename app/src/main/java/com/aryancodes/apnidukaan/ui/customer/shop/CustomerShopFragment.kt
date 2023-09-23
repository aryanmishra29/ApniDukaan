package com.aryancodes.apnidukaan.ui.customer.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aryancodes.apnidukaan.adapter.CustomerShopAdapter
import com.aryancodes.apnidukaan.databinding.FragmentCustomerShopBinding
import com.aryancodes.apnidukaan.model.CustomerShopModel

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
        val shopList = ArrayList<CustomerShopModel>()
        val shopAdapter = CustomerShopAdapter(shopList)
        binding.customerShopsRecycler.layoutManager = LinearLayoutManager(activity)
        binding.customerShopsRecycler.adapter = shopAdapter
        customerShopViewModel.shopList.observe(viewLifecycleOwner){
            shopList.clear()
            shopList.addAll(it)
            shopAdapter.notifyDataSetChanged()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}