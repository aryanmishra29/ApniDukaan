package com.aryancodes.apnidukaan.util

import androidx.datastore.preferences.core.stringPreferencesKey

object DatastoreKeys {
    val userTypeKey = stringPreferencesKey("userType")
    val isLoggedInKey = stringPreferencesKey("isLoggedIn")
    val languageKey = stringPreferencesKey("language")
}