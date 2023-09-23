package com.aryancodes.apnidukaan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aryancodes.apnidukaan.R
import com.aryancodes.apnidukaan.model.CustomerShopModel

class CustomerShopAdapter(private val shopList : ArrayList<CustomerShopModel>) : RecyclerView.Adapter<CustomerShopAdapter.CustomerShopViewHolder>() {
    inner class CustomerShopViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val customerShopImage : ImageView
        val customerShopName : TextView
        val customerShopStars : TextView
        val customerShopTiming: TextView
        val customerShopClosedDay : TextView
        val customerShopTypeImage : ImageView

        init {
            customerShopImage = view.findViewById(R.id.customer_shop_image)
            customerShopName  = view.findViewById(R.id.customer_shop_name)
            customerShopStars = view.findViewById(R.id.customer_shop_star)
            customerShopTiming = view.findViewById(R.id.customer_shop_today_open)
            customerShopClosedDay = view.findViewById(R.id.customer_shop_closed_day)
            customerShopTypeImage = view.findViewById(R.id.customer_shop_type_image)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CustomerShopAdapter.CustomerShopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.customer_shop_list_element, parent, false)
        return CustomerShopViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CustomerShopAdapter.CustomerShopViewHolder,
        position: Int
    ) {
        holder.customerShopImage.setImageResource(shopList[position].shopImageResource)
        holder.customerShopName.text = shopList[position].shopName
        holder.customerShopStars.text = shopList[position].shopStars.toString()
        holder.customerShopTiming.text = shopList[position].shopTiming
        holder.customerShopClosedDay.text = shopList[position].shopClosedDay
        holder.customerShopTypeImage.setImageResource(shopList[position].shopTypeImageResource)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }
}