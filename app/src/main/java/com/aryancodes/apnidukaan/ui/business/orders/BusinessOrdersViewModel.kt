package com.aryancodes.apnidukaan.ui.business.orders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BusinessOrdersViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Orders Fragment"
    }
    val text : LiveData<String> = _text
}