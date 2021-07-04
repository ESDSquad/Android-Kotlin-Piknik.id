package com.esdsquad.piknik.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: Data? = null,

    @field:SerializedName("message")
    val message: String? = null
) {

    data class Data(

        @field:SerializedName("user_id")
        val userId: Int? = null,

        @field:SerializedName("nama_lengkap")
        val namaLengkap: String? = null,

        @field:SerializedName("email")
        val email: String? = null,

        @field:SerializedName("token")
        val token: String? = null
    )

}