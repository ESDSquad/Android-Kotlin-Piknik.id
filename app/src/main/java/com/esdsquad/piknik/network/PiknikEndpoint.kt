package com.esdsquad.piknik.network

import com.esdsquad.piknik.network.response.LoginResponse
import com.esdsquad.piknik.network.response.ProfileResponse
import com.esdsquad.piknik.network.response.RegisterResponse
import retrofit2.Response
import retrofit2.http.*

interface PiknikEndpoint {

    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("nama_lengkap") nama_lengkap: String,
        @Field("email") email: String,
        @Field("password") password: String,
        @Field("password_confirmation") password_confirmation: String
    ): Response<RegisterResponse>

    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<LoginResponse>

    @GET("profile")
    suspend fun getProfile(
        @Header("Authorization") authorization: String
    ): Response<ProfileResponse>
}