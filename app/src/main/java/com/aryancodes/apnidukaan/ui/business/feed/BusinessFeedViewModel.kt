package com.aryancodes.apnidukaan.ui.business.feed

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.model.BusinessFeedModel

class BusinessFeedViewModel : ViewModel() {
    private val _feedList = MutableLiveData<ArrayList<BusinessFeedModel>>().apply {
        value = arrayListOf( BusinessFeedModel(R.drawable.feed_sample_1,"Feed1"),
            BusinessFeedModel(R.drawable.feed_sample_2, "Feed2"),
            BusinessFeedModel(R.drawable.feed_sample_3, "Feed3")
        )
    }
    val feedList : LiveData<ArrayList<BusinessFeedModel>> = _feedList

}