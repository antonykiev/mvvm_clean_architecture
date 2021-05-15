package com.example.cleanarchitecture.data.remote.api

import com.example.cleanarchitecture.data.remote.model.YesNoResponse
import retrofit2.Response
import retrofit2.http.GET

interface YesNoApi {

    @GET("/api")
    suspend fun getAnswer(): Response<YesNoResponse>
}