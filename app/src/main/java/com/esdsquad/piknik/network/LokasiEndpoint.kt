package com.esdsquad.piknik.network

import com.esdsquad.piknik.network.response.KotaResponse
import com.esdsquad.piknik.network.response.ProvinsiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface LokasiEndpoint {
    @GET("provinsi")
    suspend fun provinsi(): Response<ProvinsiResponse>

    @GET("kota")
    suspend fun kota(@Query("id_provinsi") provinsi: String?): Response<KotaResponse>
}