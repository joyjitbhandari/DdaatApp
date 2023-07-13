package com.flynaut.healthtag.util

import android.content.Context
import android.content.SharedPreferences
import androidx.annotation.StringDef
import com.google.gson.Gson
import java.util.concurrent.atomic.AtomicBoolean


class PrefsManager (context: Context) {

    private val sharedPrefName = "ddaat_preference"
    private val gson = Gson()
    private var preferences: SharedPreferences

    companion object {
        const val PREF_PROFILE = "PREF_PROFILE"
        const val PREF_API_TOKEN = "PREF_API_TOKEN"
        const val PREF_USER_ID = "PREF_USER_ID"

        const val IS_ONBOARDING_COMPLETED = "OnBoarding"
        const val IS_LOG_IN = "IsLogIn"

        @StringDef(PREF_PROFILE, PREF_API_TOKEN, PREF_USER_ID,IS_ONBOARDING_COMPLETED,IS_LOG_IN)
        @Retention(AnnotationRetention.SOURCE)
        annotation class PrefKey

        private lateinit var instance: PrefsManager
        private val isInitialized =
            AtomicBoolean()     // To check if instance was previously initialized or not

        fun initialize(context: Context) {
            if (!isInitialized.getAndSet(true)) {
                instance = PrefsManager(context.applicationContext)
            }
        }

        fun get(): PrefsManager = instance
    }

    init {
        preferences = context.getSharedPreferences(sharedPrefName, Context.MODE_PRIVATE)
    }

    fun save(@PrefKey key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    fun save(@PrefKey key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }

    fun save(@PrefKey key: String, value: Long) {
        preferences.edit().putLong(key, value).apply()
    }

    fun save(@PrefKey key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }

    fun save(@PrefKey key: String, `object`: Any?) {
        if (`object` == null) {
            throw IllegalArgumentException("object is null")
        }

        // Convert the provided object to JSON string
        save(key, gson.toJson(`object`))
    }

    fun getString(@PrefKey key: String, defValue: String?): String =
        preferences.getString(key, defValue).toString()

    //   fun getInt(@PrefKey key: String, defValue: Int): Int = preferences.getInt(key, defValue)

//    fun getFloat(@PrefKey key: String, defValue: Float): Float = preferences.getFloat(key, defValue)

    fun getBoolean(@PrefKey key: String, defValue: Boolean): Boolean =
        preferences.getBoolean(key, defValue)

    fun <T> getObject(@PrefKey key: String, objectClass: Class<T>): T? {
        val jsonString = preferences.getString(key, null)
        return if (jsonString == null) {
            null
        } else {
            try {
                gson.fromJson(jsonString, objectClass)
            } catch (e: Exception) {
                throw IllegalArgumentException("Object stored with key $key is instance of other class")
            }
        }
    }

    fun clearPrefs() {
        preferences.edit().clear().apply()
    }

    fun removeKey(keyName: String) {
        preferences.edit().remove(keyName).commit()
    }


}