package com.example.core.di

import com.example.core.network.RemoteDataSource
import org.koin.dsl.module


val remoteDataSourceModule = module {
    single { RemoteDataSource(get(), get()) }
}