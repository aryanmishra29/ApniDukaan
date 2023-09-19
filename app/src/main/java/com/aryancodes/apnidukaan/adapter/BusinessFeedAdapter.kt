package com.aryancodes.apnidukaan.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.model.BusinessFeedModel

class BusinessFeedAdapter(private val feedList: ArrayList<BusinessFeedModel>) : RecyclerView.Adapter<BusinessFeedAdapter.BusinessFeedViewHolder>() {
    inner class BusinessFeedViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val feedTitleTextView : TextView
        val feedImageView : ImageView
        init{
            feedTitleTextView = view.findViewById(R.id.business_feed_title)
            feedImageView = view.findViewById(R.id.business_feed_image)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessFeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.business_feed_list_element, parent, false)
        return BusinessFeedViewHolder(view)
    }
    override fun onBindViewHolder(holder: BusinessFeedViewHolder, position: Int) {
        holder.feedTitleTextView.text = feedList[position].feedTitle
        holder.feedImageView.setImageResource(feedList[position].imageResource)
        Log.d("AdapterFeed",feedList[position].toString())
    }
    override fun getItemCount(): Int {
        return feedList.size
    }
}