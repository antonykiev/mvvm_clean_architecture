package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.remote.source.YesNoDataSource
import com.example.cleanarchitecture.domain.entity.GifAnswer
import com.example.cleanarchitecture.domain.repository.GifRepository

class GifRepositoryImpl(private val dataSource: YesNoDataSource) : GifRepository {

    override suspend fun getGifAnswer(): GifAnswer =
        dataSource.getAnswer().let { GifAnswer(it.answer, it.image) }
}
