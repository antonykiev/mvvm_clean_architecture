package com.example.cleanarchitecture.presentation.di

import com.example.cleanarchitecture.domain.logger.Logger
import com.example.cleanarchitecture.presentation.logger.LoggerImpl
import com.example.cleanarchitecture.presentation.viewmodel.TasksViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

private val module: Module = module {
    viewModel { TasksViewModel(get(), get(), get(), get(), get()) }

    single<Logger> { LoggerImpl() }
}

val presentationModule = listOf(module)
