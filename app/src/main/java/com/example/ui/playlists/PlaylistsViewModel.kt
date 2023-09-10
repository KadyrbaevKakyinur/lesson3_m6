package com.example.ui.playlists

import androidx.lifecycle.LiveData
import com.example.core.base.BaseViewModel
import com.example.core.network.Resource
import com.example.data.model.PlaylistsModel
import com.example.data.repository.Repository

class PlaylistsViewModel(private val repository: Repository) : BaseViewModel() {

    fun getPlayList(): LiveData<Resource<PlaylistsModel>> = repository.getPlaylist()

}
