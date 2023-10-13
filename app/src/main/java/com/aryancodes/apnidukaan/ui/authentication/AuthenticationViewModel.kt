package com.aryancodes.apnidukaan.ui.authentication

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.Preferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.aryancodes.apnidukaan.repository.AuthRepository
import com.aryancodes.apnidukaan.repository.BusinessOwnerRepository
import com.aryancodes.apnidukaan.repository.CustomerRepository
import com.aryancodes.apnidukaan.repository.DataStoreRepository
import com.aryancodes.apnidukaan.util.AndroidUtil
import com.google.firebase.FirebaseException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthenticationViewModel(
    private val dataStoreRepository: DataStoreRepository,
    private val authRepository: AuthRepository,
    private val customerRepository: CustomerRepository,
    private val businessOwnerRepository: BusinessOwnerRepository,
    private val context: Context) : ViewModel(){

    private var previousVerificationId: String? = null
    private var resendToken: PhoneAuthProvider.ForceResendingToken? = null
    private val _loginUiState = MutableStateFlow<LoginUiState>(LoginUiState.Empty)
    var loginUiState = _loginUiState.asStateFlow()

    suspend fun saveData(key: Preferences.Key<String>, value: String) {
        dataStoreRepository.saveData(key, value)
    }

    fun loadData(key: Preferences.Key<String>) : LiveData<String> {
        return dataStoreRepository.loadData(key).asLiveData()
    }

    private val phoneVerificationCallback = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {
            Log.d(TAG, "onVerificationCompleted:$credential")
            authRepository.signInWithPhoneCredentials(credential)
        }

        override fun onVerificationFailed(e: FirebaseException) {
            Log.w(TAG, "onVerificationFailed", e)
            AndroidUtil.showToast(context, e.message.toString())
        }

        override fun onCodeSent(verificationId: String, resendingToken: PhoneAuthProvider.ForceResendingToken) {
            _loginUiState.apply { value = LoginUiState.CodeSent }
            Log.d(TAG, "onCodeSent:$verificationId")

            previousVerificationId = verificationId
            resendToken = resendingToken
        }
    }

    fun sendOtp(phoneNumber : String){
        authRepository.authenticateWithPhoneNumber(phoneNumber, phoneVerificationCallback)
    }

    sealed class LoginUiState{
        data object CodeSent: LoginUiState()
        data object SuccessForExistingUser: LoginUiState()
        data object SuccessForNewUser: LoginUiState()
        data object Empty: LoginUiState()
        data class Error(val message: String): LoginUiState()

    }
}