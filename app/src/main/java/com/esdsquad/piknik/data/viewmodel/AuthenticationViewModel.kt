package com.esdsquad.piknik.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esdsquad.piknik.network.PiknikRepository
import com.esdsquad.piknik.storage.perferences.CredentialPreferencesModel
import com.esdsquad.piknik.storage.perferences.TokenPreferencesModel

class AuthenticationViewModel(
    private val repository: PiknikRepository
) : ViewModel() {
    val preferencesToken: MutableLiveData<TokenPreferencesModel> = MutableLiveData()
    val preferencesCredential: MutableLiveData<List<CredentialPreferencesModel>> = MutableLiveData()

    fun getPreferencesToken() {
        preferencesToken.value = repository.getPreferencesToken()
    }

    fun savePrefToken(token: String?) {
        repository.savePreferencesToken(token)
    }

    fun getPreferencesCredential() {
        preferencesCredential.value = repository.getPreferencesCredential()
    }

    fun savePrefCredential(username: String?, password: String?) {
        repository.savePreferencesCredential(username, password)
    }
}