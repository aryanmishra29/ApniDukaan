package com.aryancodes.apnidukaan.repository

import com.aryancodes.apnidukaan.model.CustomerModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class CustomerRepository {
    private val database = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun getCurrentUserDetails() : CustomerModel?{
        var customer: CustomerModel? = null
        database.collection("customers").document(auth.uid!!)
            .get().addOnCompleteListener {
                if(it.isSuccessful){
                    customer = it.result.toObject(CustomerModel::class.java)
                }
            }
        return customer
    }
}