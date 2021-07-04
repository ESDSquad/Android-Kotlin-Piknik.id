package com.esdsquad.piknik.network.response

import com.google.gson.annotations.SerializedName

data class ProfileResponse(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("message")
	val message: String? = null
) {
	data class Data(

		@field:SerializedName("updated_at")
		val updatedAt: String? = null,

		@field:SerializedName("nama_lengkap")
		val namaLengkap: String? = null,

		@field:SerializedName("created_at")
		val createdAt: String? = null,

		@field:SerializedName("email_verified_at")
		val emailVerifiedAt: Any? = null,

		@field:SerializedName("id")
		val id: Int? = null,

		@field:SerializedName("email")
		val email: String? = null
	)
}
