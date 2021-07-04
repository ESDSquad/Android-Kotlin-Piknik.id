package com.esdsquad.piknik.network

import com.esdsquad.piknik.storage.perferences.*
import com.esdsquad.piknik.storage.persistence.PiknikDatabase
import com.esdsquad.piknik.storage.persistence.PiknikEntity

class PiknikRepository(
    private val api: PiknikEndpoint,
    private val pref: PiknikPreferences,
    private val db: PiknikDatabase
) {
    suspend fun fetchGet() = api.exampleGet()
    suspend fun fetchPost() = api.examplePost()

    fun savePreferencesOnboarding(first: Boolean?) {
        pref.put(prefFirst, first!!)
    }

    fun getPreferencesOnboarding(): OnboardingPreferencesModel {
        return OnboardingPreferencesModel(pref.getBoolean(prefFirst))
    }

    fun savePreferencesToken(token: String?) {
        pref.put(prefToken, token!!)
    }

    fun getPreferencesToken(): TokenPreferencesModel {
        return TokenPreferencesModel(pref.getString(prefToken))
    }

    fun savePreferencesCredential(username: String?, password: String?) {
        pref.put(prefUsername, username!!)
        pref.put(prefPassword, password!!)
    }

    fun getPreferencesCredential(): List<CredentialPreferencesModel> {
        return listOf<CredentialPreferencesModel>(
            CredentialPreferencesModel(
                username = pref.getString(prefUsername), password = pref.getString(
                    prefPassword
                )
            )
        )
    }

    suspend fun saveDataExample(piknikEntity: PiknikEntity) {
        db.exampleDao().insert(piknikEntity)
    }

    fun getDataExample() = db.exampleDao().select()

    suspend fun deleteDataExample() {
        db.exampleDao().deleteAll()
    }
}