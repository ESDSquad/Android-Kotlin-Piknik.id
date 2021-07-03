package com.esdsquad.piknik.storage.perferences

import android.content.Context
import android.content.SharedPreferences

private const val prefName = "Piknik.pref"

class PiknikPreferences(context: Context) {

    private var sharedPref: SharedPreferences =
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor

    init {
        editor = sharedPref.edit()
    }

    fun put(key: String, value: String) {
        editor.putString(key, value)
            .apply()
    }

    fun put(key: String, value: Boolean) {
        editor.putBoolean(key, value)
            .apply()
    }

    fun getString(key: String): String? {
        return sharedPref.getString(key, null)
    }

    fun getBoolean(key: String): Boolean? {
        return sharedPref.getBoolean(key, false)
    }
}