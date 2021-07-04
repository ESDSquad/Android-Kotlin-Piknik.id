package com.esdsquad.piknik.data.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esdsquad.piknik.network.LokasiRepository
import com.esdsquad.piknik.network.Resource
import com.esdsquad.piknik.network.response.KotaResponse
import com.esdsquad.piknik.network.response.ProvinsiResponse
import com.esdsquad.piknik.storage.perferences.LokasiPreferencesModel
import kotlinx.coroutines.launch

class MainViewModel(
    val repositoryLokasi: LokasiRepository
) : ViewModel() {

    val provinsiResponse: MutableLiveData<Resource<ProvinsiResponse>> = MutableLiveData()
    val kotaResponse: MutableLiveData<Resource<KotaResponse>> = MutableLiveData()
    val preferencesLokasi: MutableLiveData<List<LokasiPreferencesModel>> = MutableLiveData()

    fun fetchProvinsi() = viewModelScope.launch {
        provinsiResponse.value = Resource.Loading()
        try {
            val response = repositoryLokasi.fetchProvinsi()
            provinsiResponse.value = Resource.Success(response.body()!!)
        } catch (e: Exception) {
            provinsiResponse.value = Resource.Error(e.message.toString())
        }
    }

    fun fetchKota(id: String?) = viewModelScope.launch {
        kotaResponse.value = Resource.Loading()
        try {
            val response = repositoryLokasi.fetchKota(id)
            kotaResponse.value = Resource.Success(response.body()!!)
        } catch (e: Exception) {
            kotaResponse.value = Resource.Error(e.message.toString())
        }
    }

    fun savePreferencesProvinsi(provinsi: String?) {
        repositoryLokasi.savePreferencesProvinsi(provinsi)
    }

    fun savePreferencesKota(kota: String?) {
        repositoryLokasi.savePreferencesKota(kota)
    }

    fun getPreferencesLokasi() {
        preferencesLokasi.value = repositoryLokasi.getPreferencesLokasi()
    }

}