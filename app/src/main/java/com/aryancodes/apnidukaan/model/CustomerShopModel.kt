package com.aryancodes.apnidukaan.model

data class CustomerShopModel(
    val shopImageResource: Int,
    val shopName: String,
    val shopStars : Float,
    val shopTiming : String,
    val shopClosedDay: String,
    val shopDistance : String,
    val shopTypeImageResource : Int
)
