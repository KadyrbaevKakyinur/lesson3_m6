package com.example.core.di

import com.example.data.repository.Repository
import org.koin.dsl.module


val repositoryModule = module {
    single { Repository(get()) }
}