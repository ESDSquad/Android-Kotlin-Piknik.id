package com.esdsquad.piknik.network

import com.esdsquad.piknik.network.response.ExampleResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ExampleEndpoint {
    @GET("")
    suspend fun exampleGet(): Response<ExampleResponse>

    @POST("")
    suspend fun examplePost(): Response<ExampleResponse>
}