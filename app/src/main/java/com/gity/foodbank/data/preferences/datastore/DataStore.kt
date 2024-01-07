package com.gity.foodbank.data.preferences.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(
    name = "token_preferences"
)

class DataStore(private val dataStore: DataStore<Preferences>) {

    private val TOKEN = stringPreferencesKey("token")

    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[TOKEN] = token
        }
    }

    suspend fun getToken(): String {
        val preferences = dataStore.data.first()
        return preferences[TOKEN] ?: ""
    }

    suspend fun clearToken() {
        dataStore.edit { preferences ->
            preferences.remove(TOKEN)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: com.gity.foodbank.data.preferences.datastore.DataStore? = null
        fun getInstance(dataStore: DataStore<Preferences>): com.gity.foodbank.data.preferences.datastore.DataStore {
            return INSTANCE ?: synchronized(this) {
                val instance = DataStore(dataStore)
                INSTANCE = instance
                instance
            }
        }
    }

}

