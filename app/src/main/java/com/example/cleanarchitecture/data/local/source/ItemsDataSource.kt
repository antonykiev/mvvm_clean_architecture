package com.example.cleanarchitecture.data.local.source

import com.example.cleanarchitecture.data.local.dao.ItemDao
import com.example.cleanarchitecture.data.local.entity.ItemEntity
import kotlinx.coroutines.flow.Flow

class ItemsDataSource(private val dao: ItemDao) {
    fun getItems(): Flow<List<ItemEntity>> = dao.getAll()

    suspend fun insert(item: ItemEntity): Long = dao.insert(item)

    suspend fun getItem(itemId: Long): ItemEntity = dao.getById(itemId)

    suspend fun deleteItem(itemId: Long): Boolean = dao.deleteById(itemId) > 0
}