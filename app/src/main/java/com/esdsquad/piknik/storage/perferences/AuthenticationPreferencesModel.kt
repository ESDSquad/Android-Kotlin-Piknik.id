package com.esdsquad.piknik.storage.perferences

data class TokenPreferencesModel(val token: String?)
data class CredentialPreferencesModel(
    val id: String?,
    val nama_lengkap: String?,
    val email: String?
)