package com.example.cleanarchitecture.data.remote.source

import com.example.cleanarchitecture.data.remote.api.YesNoApi
import com.example.cleanarchitecture.data.remote.model.YesNoResponse
import java.io.IOException

class YesNoDataSource(private val api: YesNoApi) {

    suspend fun getAnswer(): YesNoResponse {
        val response = api.getAnswer()

        if (!response.isSuccessful) throw IOException("Unsuccessful response")

        return response.body() ?: throw IllegalStateException("Empty response body")
    }
}
