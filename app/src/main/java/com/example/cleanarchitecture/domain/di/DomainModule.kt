package com.example.cleanarchitecture.domain.di

import com.example.cleanarchitecture.domain.usecase.CreateItemUseCase
import com.example.cleanarchitecture.domain.usecase.DeleteItemUseCase
import com.example.cleanarchitecture.domain.usecase.GetAnswerUseCase
import com.example.cleanarchitecture.domain.usecase.GetItemsUseCase
import org.koin.dsl.module

private val modules = module {
    single { GetAnswerUseCase(get()) }
    single { GetItemsUseCase(get()) }
    single { CreateItemUseCase(get()) }
    single { DeleteItemUseCase(get()) }
}

val domainModules = listOf(modules)