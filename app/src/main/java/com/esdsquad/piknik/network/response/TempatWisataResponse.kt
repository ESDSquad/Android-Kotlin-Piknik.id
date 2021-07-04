package com.esdsquad.piknik.network.response

import com.google.gson.annotations.SerializedName

data class TempatWisataResponse(

    @field:SerializedName("TempatWisataResponse")
    val tempatWisataResponse: List<TempatWisataResponseItem?>? = null
) {

    data class TempatWisataResponseItem(

        @field:SerializedName("nama")
        val nama: String? = null,

        @field:SerializedName("harga")
        val harga: Int? = null,

        @field:SerializedName("id")
        val id: Int? = null,

        @field:SerializedName("deskripsi")
        val deskripsi: String? = null,

        @field:SerializedName("map")
        val map: String? = null,

        @field:SerializedName("picture")
        val picture: String? = null,

        @field:SerializedName("alamat")
        val alamat: String? = null
    )

}