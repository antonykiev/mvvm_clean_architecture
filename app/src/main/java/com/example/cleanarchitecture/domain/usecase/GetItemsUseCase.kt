package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.entity.Item
import com.example.cleanarchitecture.domain.repository.ItemsRepository
import kotlinx.coroutines.flow.Flow

class GetItemsUseCase(private val repo: ItemsRepository) {

    fun execute(): Flow<List<Item>> {
        return repo.getItems()
    }
}