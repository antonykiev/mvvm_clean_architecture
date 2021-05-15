package com.example.cleanarchitecture.domain.repository

import com.example.cleanarchitecture.domain.entity.GifAnswer

interface GifRepository {

    suspend fun getGifAnswer(): GifAnswer

}