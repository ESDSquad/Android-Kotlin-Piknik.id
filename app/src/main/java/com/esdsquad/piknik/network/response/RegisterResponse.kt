package com.esdsquad.piknik.network.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("data")
    val data: Data? = null,

    @field:SerializedName("message")
    val message: String? = null
) {

    data class Data(

        @field:SerializedName("user")
        val user: User? = null,

        @field:SerializedName("token")
        val token: String? = null
    ) {

        data class User(

            @field:SerializedName("updated_at")
            val updatedAt: String? = null,

            @field:SerializedName("nama_lengkap")
            val namaLengkap: String? = null,

            @field:SerializedName("created_at")
            val createdAt: String? = null,

            @field:SerializedName("id")
            val id: Int? = null,

            @field:SerializedName("email")
            val email: String? = null
        )

    }

}
