package com.aryancodes.apnidukaan.ui.customer.shop

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.model.BusinessFeedModel
import com.aryancodes.apnidukaan.model.CustomerShopModel

class CustomerShopViewModel : ViewModel() {

    private val _shopList = MutableLiveData<ArrayList<CustomerShopModel>>().apply {
        value = arrayListOf(CustomerShopModel(R.drawable.shop_sample_1, "Kavita Grocery Store", 3.8f, "Open today till 9 pm", "Sunday Closed", "2.3 km from you", R.drawable.icon_groceries),
            CustomerShopModel(R.drawable.shop_sample_2, "Noori bakery", 3.1f, "Open today till 6 pm", "Monday Closed", "0.7 km from you", R.drawable.icon_dairy),
            CustomerShopModel(R.drawable.shop_sample_3, "Anuj Bhujiawala", 4.2f, "Open today till 7 pm", "Runs 8PM to 7AM daily", "2 km from you", R.drawable.icon_groceries),
            CustomerShopModel(R.drawable.shop_sample_4, "Shyamlal Stationery Store", 3.9f, "Open today till 10 pm", "Runs daily", "1.2 km from you", R.drawable.icon_stationery),
            CustomerShopModel(R.drawable.shop_sample_5, "Mukesh Aata Chakki", 4.9f, "Open today till 11 pm", "Monday Closed", "2.7 km from you", R.drawable.icon_groceries)
        )
    }
    val shopList : LiveData<ArrayList<CustomerShopModel>> = _shopList
}