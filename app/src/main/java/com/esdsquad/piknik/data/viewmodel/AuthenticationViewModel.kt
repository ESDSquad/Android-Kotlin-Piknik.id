package com.esdsquad.piknik.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esdsquad.piknik.network.PiknikRepository
import com.esdsquad.piknik.network.Resource
import com.esdsquad.piknik.network.response.LoginResponse
import com.esdsquad.piknik.network.response.ProfileResponse
import com.esdsquad.piknik.network.response.RegisterResponse
import com.esdsquad.piknik.storage.perferences.CredentialPreferencesModel
import com.esdsquad.piknik.storage.perferences.TokenPreferencesModel
import kotlinx.coroutines.launch

class AuthenticationViewModel(
    private val repository: PiknikRepository
) : ViewModel() {
    val loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val registerResponse: MutableLiveData<Resource<RegisterResponse>> = MutableLiveData()
    val profileResponse: MutableLiveData<Resource<ProfileResponse>> = MutableLiveData()
    val preferencesToken: MutableLiveData<TokenPreferencesModel> = MutableLiveData()
    val preferencesCredential: MutableLiveData<List<CredentialPreferencesModel>> = MutableLiveData()

    fun login(email: String, password: String) = viewModelScope.launch {
        loginResponse.value = Resource.Loading()
        try {
            val response = repository.login(email, password)
            loginResponse.value = Resource.Success(response.body()!!)
            val retrive = response.body()!!.data!!

            savePrefToken(retrive.token)
            savePrefCredential(retrive.userId?.toString(), retrive.namaLengkap, retrive.email)
        } catch (e: Exception) {
            loginResponse.value = Resource.Error(e.message.toString())
        }
    }

    fun register(
        nama_lengkap: String,
        email: String,
        password: String,
        password_confirmation: String
    ) = viewModelScope.launch {
        registerResponse.value = Resource.Loading()
        try {
            val response = repository.register(nama_lengkap, email, password, password_confirmation)
            registerResponse.value = Resource.Success(response.body()!!)
            val retrive = response.body()!!.data!!

            savePrefToken(retrive.token)
            savePrefCredential(
                retrive.user?.id.toString(),
                retrive.user!!.namaLengkap,
                retrive.user.email
            )
        } catch (e: Exception) {
            registerResponse.value = Resource.Error(e.message.toString())
        }
    }

    fun getProfile(authentication: String) = viewModelScope.launch {
        profileResponse.value = Resource.Loading()
        try {
            val response = repository.getProfile(authentication)
            profileResponse.value = Resource.Success(response.body()!!)
        } catch (e: Exception) {
            profileResponse.value = Resource.Error(e.message.toString())
        }
    }


    fun getPreferencesToken() {
        preferencesToken.value = repository.getPreferencesToken()
    }

    fun savePrefToken(token: String?) {
        repository.savePreferencesToken(token)
    }

    fun getPreferencesCredential() {
        preferencesCredential.value = repository.getPreferencesCredential()
    }

    fun savePrefCredential(id: String?, nama_lengkap: String?, email: String?) {
        repository.savePreferencesCredential(id!!, nama_lengkap!!, email!!)
    }
}