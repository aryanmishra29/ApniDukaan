package com.aryancodes.apnidukaan.ui.business.feed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.adapter.BusinessFeedAdapter
import com.aryancodes.apnidukaan.databinding.FragmentBusinessFeedBinding
import com.aryancodes.apnidukaan.databinding.FragmentCustomerCartBinding
import com.aryancodes.apnidukaan.model.BusinessFeedModel
import com.aryancodes.apnidukaan.ui.customer.cart.CustomerCartViewModel

class BusinessFeedFragment : Fragment() {

    private var _binding: FragmentBusinessFeedBinding? = null
    private val binding get() = _binding!!
    private lateinit var feedRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val businessFeedViewModel = ViewModelProvider(this).get(BusinessFeedViewModel::class.java)

        _binding = FragmentBusinessFeedBinding.inflate(inflater, container, false)
        val root: View = binding.root
        // Feed Recycler
        feedRecyclerView = binding.businessFeedRecycler
        var feedList = ArrayList<BusinessFeedModel>()
        val businessFeedAdapter = BusinessFeedAdapter(feedList)
        feedRecyclerView.layoutManager = LinearLayoutManager(activity)
        feedRecyclerView.adapter = businessFeedAdapter
        businessFeedViewModel.feedList.observe(viewLifecycleOwner){
            feedList.clear()
            feedList.addAll(it)
            Log.d("Feed",feedList.toString())
            businessFeedAdapter.notifyDataSetChanged()
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}