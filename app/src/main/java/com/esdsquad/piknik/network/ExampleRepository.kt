package com.esdsquad.piknik.network

import com.esdsquad.piknik.storage.perferences.ExamplePreferences
import com.esdsquad.piknik.storage.perferences.PreferencesModel
import com.esdsquad.piknik.storage.perferences.prefExample
import com.esdsquad.piknik.storage.persistence.ExampleDatabase
import com.esdsquad.piknik.storage.persistence.ExampleEntity

class ExampleRepository(
    private val api: ExampleEndpoint,
    private val pref: ExamplePreferences,
    private val db: ExampleDatabase
) {
    suspend fun fetchGet() = api.exampleGet()
    suspend fun fetchPost() = api.examplePost()

    fun savePreferences(example: String?) {
        pref.put(prefExample, example!!)
    }

    fun getPreferences(): PreferencesModel {
        return PreferencesModel(pref.getString(prefExample))
    }

    suspend fun saveDataExample(exampleEntity: ExampleEntity) {
        db.exampleDao().insert(exampleEntity)
    }

    fun getDataExample() = db.exampleDao().select()

    suspend fun deleteDataExample() {
        db.exampleDao().deleteAll()
    }
}