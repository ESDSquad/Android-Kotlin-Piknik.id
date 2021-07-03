package com.esdsquad.piknik.network

import com.esdsquad.piknik.storage.perferences.PiknikPreferences
import com.esdsquad.piknik.storage.perferences.PreferencesModel
import com.esdsquad.piknik.storage.perferences.prefExample
import com.esdsquad.piknik.storage.persistence.PiknikDatabase
import com.esdsquad.piknik.storage.persistence.PiknikEntity

class PiknikRepository(
    private val api: PiknikEndpoint,
    private val pref: PiknikPreferences,
    private val db: PiknikDatabase
) {
    suspend fun fetchGet() = api.exampleGet()
    suspend fun fetchPost() = api.examplePost()

    fun savePreferences(example: String?) {
        pref.put(prefExample, example!!)
    }

    fun getPreferences(): PreferencesModel {
        return PreferencesModel(pref.getString(prefExample))
    }

    suspend fun saveDataExample(piknikEntity: PiknikEntity) {
        db.exampleDao().insert(piknikEntity)
    }

    fun getDataExample() = db.exampleDao().select()

    suspend fun deleteDataExample() {
        db.exampleDao().deleteAll()
    }
}