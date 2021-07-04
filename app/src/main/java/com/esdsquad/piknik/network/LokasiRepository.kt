package com.esdsquad.piknik.network

import com.esdsquad.piknik.storage.perferences.LokasiPreferencesModel
import com.esdsquad.piknik.storage.perferences.PiknikPreferences
import com.esdsquad.piknik.storage.perferences.prefKota
import com.esdsquad.piknik.storage.perferences.prefProvinsi

class LokasiRepository(
    private val api: LokasiEndpoint,
    private val pref: PiknikPreferences,
) {

    suspend fun fetchProvinsi() = api.provinsi()

    suspend fun fetchKota(provinsi_id: String?) = api.kota(provinsi_id)

    fun savePreferencesProvinsi(provinsi: String?) {
        pref.put(prefProvinsi, provinsi!!)
    }

    fun savePreferencesKota(kota: String?) {
        pref.put(prefKota, kota!!)
    }

    fun getPreferencesLokasi(): List<LokasiPreferencesModel> {
        return listOf<LokasiPreferencesModel>(
            LokasiPreferencesModel(
                provinsi = pref.getString(prefProvinsi), kota = pref.getString(
                    prefKota
                )
            )
        )
    }
}