package com.aryancodes.apnidukaan.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DataStoreRepository(private val dataStore : DataStore<Preferences>) {

    suspend fun saveData(key: Preferences.Key<String>, value: String){
        dataStore.edit { preferences->
            preferences[key] = value
        }
    }

    fun loadData(key: Preferences.Key<String>) : Flow<String> {
        return dataStore.data.map {
            it[key] ?: ""
        }
    }

}