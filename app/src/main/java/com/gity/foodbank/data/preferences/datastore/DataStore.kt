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
    private val EMAIL = stringPreferencesKey("email")
    private val PROFILEPICTURE = stringPreferencesKey("picture")
    private val USERNAME = stringPreferencesKey("username")
    private val GUIDUSER = stringPreferencesKey("guid_user")


    suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[TOKEN] = token
        }
    }

    suspend fun getToken(): String {
        val preferences = dataStore.data.first()
        return preferences[TOKEN] ?: ""
    }

    suspend fun saveEmail(email: String) {
        dataStore.edit { preferences ->
            preferences[EMAIL] = email
        }
    }

    suspend fun saveProfilePicture(profilePicture: String) {
        dataStore.edit { preferences ->
            preferences[PROFILEPICTURE] = profilePicture
        }
    }

    suspend fun saveUsername(username: String) {
        dataStore.edit { preferences ->
            preferences[USERNAME] = username
        }
    }

    suspend fun saveGuidUser(guid: String) {
        dataStore.edit { preferences ->
            preferences[GUIDUSER] = guid
        }
    }

    suspend fun getEmail(): String {
        val preferences = dataStore.data.first()
        return preferences[EMAIL] ?: ""
    }

    suspend fun getProfilePicture(): String {
        val preferences = dataStore.data.first()
        return preferences[PROFILEPICTURE] ?: ""
    }

    suspend fun getUsername(): String {
        val preferences = dataStore.data.first()
        return preferences[USERNAME] ?: ""
    }

    suspend fun getGuidUser(): String {
        val preferences = dataStore.data.first()
        return preferences[GUIDUSER] ?: ""
    }


    suspend fun clearToken() {
        dataStore.edit { preferences ->
            preferences.remove(TOKEN)
            preferences.remove(EMAIL)
            preferences.remove(PROFILEPICTURE)
            preferences.remove(USERNAME)
            preferences.remove(GUIDUSER)
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

