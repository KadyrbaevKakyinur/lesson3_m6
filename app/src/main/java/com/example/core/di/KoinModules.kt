package com.example.core.di

import com.example.core.network.networkModule

val koinModules = listOf(
    repositoryModule,
    networkModule,
    remoteDataSourceModule,
    viewModelModule,
)