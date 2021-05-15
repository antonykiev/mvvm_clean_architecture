package com.example.cleanarchitecture.data.local.mapper

import com.example.cleanarchitecture.data.local.entity.ItemEntity
import com.example.cleanarchitecture.domain.entity.Item

private fun map(item: ItemEntity) = Item(
    id = item.id,
    description = item.description
)

fun ItemEntity.toItem() = map(this)
fun List<ItemEntity>.toItem() = map { it.toItem() }

private fun map(item: Item) = ItemEntity(
    id = item.id,
    description = item.description
)

fun Item.toItemEntity() = map(this)
fun List<Item>.toItemEntity() = map { it.toItemEntity() }