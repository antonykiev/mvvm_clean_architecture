package com.example.cleanarchitecture.domain.usecase

import com.example.cleanarchitecture.domain.entity.Item
import com.example.cleanarchitecture.domain.exception.ItemNotCreatedException
import com.example.cleanarchitecture.domain.repository.ItemsRepository

class CreateItemUseCase(private val repo: ItemsRepository) {

    suspend fun execute(description: String) {
        require(description.isNotBlank()) { "Item description must not be blank" }

        val itemToStore = Item(id = 0, description = description.capitalize())
        val id = repo.create(itemToStore)

        if (id <= 0) throw ItemNotCreatedException("Item could not be saved")
    }
}