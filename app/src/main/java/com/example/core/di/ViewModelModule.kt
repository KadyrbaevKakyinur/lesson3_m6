package com.example.core.di

import com.example.ui.details.DetailsViewModel
import com.example.ui.playlists.PlaylistsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { PlaylistsViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}