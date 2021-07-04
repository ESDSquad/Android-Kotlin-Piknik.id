package com.esdsquad.piknik.network

import com.esdsquad.piknik.storage.perferences.*

class PiknikRepository(
    private val api: PiknikEndpoint,
    private val pref: PiknikPreferences,
) {
    suspend fun register(
        nama_lengkap: String,
        email: String,
        password: String,
        password_confirmation: String
    ) = api.register(nama_lengkap, email, password, password_confirmation)

    suspend fun login(email: String, password: String) = api.login(email, password)
    suspend fun getProfile(authorization: String) = api.getProfile(authorization)


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

    fun savePreferencesCredential(id: String, nama_lengkap: String, email: String) {
        pref.put(prefUserId, id)
        pref.put(prefNamaLengkap, nama_lengkap)
        pref.put(prefEmail, email)
    }

    fun getPreferencesCredential(): List<CredentialPreferencesModel> {
        return listOf<CredentialPreferencesModel>(
            CredentialPreferencesModel(
                id = pref.getString(prefUserId),
                nama_lengkap = pref.getString(prefNamaLengkap),
                email = pref.getString(prefEmail)
            )
        )
    }

}