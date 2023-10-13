package com.aryancodes.apnidukaan.repository

import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class AuthRepository(private val activity: AppCompatActivity) {

    private val auth = FirebaseAuth.getInstance()

    fun authenticateWithPhoneNumber(phoneNumber: String, callback : PhoneAuthProvider.OnVerificationStateChangedCallbacks){
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)
            .setTimeout(120L, TimeUnit.SECONDS)
            .setActivity(activity)
            .setCallbacks(callback)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun signInWithPhoneCredentials(credential: PhoneAuthCredential) : Task<AuthResult>{
        return auth.signInWithCredential(credential)
            .addOnCompleteListener{}
    }
}