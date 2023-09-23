package com.aryancodes.apnidukaan.ui.business.feed

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.model.BusinessFeedModel

class BusinessFeedViewModel : ViewModel() {
    private val _feedList = MutableLiveData<ArrayList<BusinessFeedModel>>().apply {
        value = arrayListOf( BusinessFeedModel(R.drawable.feed_sample_1, "अपने   छोटे  व्यवसाय को बढ़ाने के लिए 6 तरीके !"),
            BusinessFeedModel(R.drawable.feed_sample_2, "अपने   छोटे  व्यवसाय को बढ़ाने के लिए !"),
            BusinessFeedModel(R.drawable.feed_sample_3, "अपने   छोटे  व्यवसाय को बढ़ाने के लिए !")
        )
    }
    val feedList : LiveData<ArrayList<BusinessFeedModel>> = _feedList

}