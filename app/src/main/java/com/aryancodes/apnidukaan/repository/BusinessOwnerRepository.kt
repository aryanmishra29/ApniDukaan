package com.aryancodes.apnidukaan.repository

import com.aryancodes.apnidukaan.model.BusinessOwnerModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class BusinessOwnerRepository {
    private val database = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun getCurrentUserDetails() : BusinessOwnerModel?{
        var businessOwner: BusinessOwnerModel? = null
        database.collection("business_owners").document(auth.uid!!)
            .get().addOnCompleteListener {
                if(it.isSuccessful){
                    businessOwner = it.result.toObject(BusinessOwnerModel::class.java)
                }
            }
        return businessOwner
    }

    fun saveUserDetails(businessOwner : BusinessOwnerModel){
        database.collection("business_owners").add(businessOwner)
    }
}