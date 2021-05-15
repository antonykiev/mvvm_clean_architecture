package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.entity.Item
import com.example.cleanarchitecture.domain.exception.ItemNotDeletedException
import com.example.cleanarchitecture.domain.repository.ItemsRepository

class DeleteItemUseCase(private val repo: ItemsRepository) {

    suspend fun execute(item: Item) {
        require(item.id > 0) { "Item does not have a valid Id" }

        val deleted = repo.delete(item.id)

        if (!deleted) throw ItemNotDeletedException("Item could not be deleted")
    }
}