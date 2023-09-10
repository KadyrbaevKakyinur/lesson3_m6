package com.example.ui.details

import androidx.lifecycle.LiveData
import com.example.core.base.BaseViewModel
import com.example.data.model.PlaylistsModel
import com.example.data.repository.Repository

class DetailsViewModel(private val repository: Repository) : BaseViewModel() {

    fun getDetails(playlistId: String): LiveData<com.example.core.network.Resource<PlaylistsModel>> = repository.getDetails(playlistId)

}