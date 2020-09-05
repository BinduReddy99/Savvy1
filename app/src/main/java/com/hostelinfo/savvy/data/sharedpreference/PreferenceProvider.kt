package com.hostelinfo.savvy.data.sharedpreference

import android.content.Context
import android.content.SharedPreferences


const val LOGIN_TOKEN = "login_token"
const val IS_LOGGED_IN = "is_logged_in"

class PreferenceProvider(private val context: Context) {
    private val appContext = context.applicationContext
    private val preference: SharedPreferences
        get() = androidx.preference.PreferenceManager.getDefaultSharedPreferences(
            appContext
        )
    fun storeValue(key: String, value: String){
        preference.edit().putString(key, value).apply()
    }

    fun storeValue(key: String, value: Boolean){
        preference.edit().putBoolean(key, value).apply()
    }

    fun getsharedBoolean(key: String): Boolean = preference.getBoolean(key, false)

    fun getSharedString(key: String): String = preference.getString(key, "")!!

    fun clearAllData(){
        preference.edit().clear().apply()
    }


}