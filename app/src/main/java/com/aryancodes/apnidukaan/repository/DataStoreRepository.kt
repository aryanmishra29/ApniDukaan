package com.aryancodes.apnidukaan.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class DataStoreRepository(private val context: Context) {

    companion object{
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("userData")
    }

    suspend fun saveData(key: Preferences.Key<String>, value: String){
        context.dataStore.edit { preferences->
            preferences[key] = value
        }
    }

    fun loadData(key: Preferences.Key<String>) : Flow<String> {
        return context.dataStore.data.map {
            it[key] ?: ""
        }
    }

}