package com.example.cleanarchitecture.data.repository

import com.example.cleanarchitecture.data.local.mapper.toItem
import com.example.cleanarchitecture.data.local.mapper.toItemEntity
import com.example.cleanarchitecture.data.local.source.ItemsDataSource
import com.example.cleanarchitecture.domain.entity.Item
import com.example.cleanarchitecture.domain.repository.ItemsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ItemsRepositoryImpl(private val dataSource: ItemsDataSource) : ItemsRepository {

    override fun getItems(): Flow<List<Item>> = dataSource.getItems().map { it.toItem() }

    override suspend fun create(item: Item): Long = dataSource.insert(item.toItemEntity())

    override suspend fun delete(itemId: Long): Boolean = dataSource.deleteItem(itemId)
}
