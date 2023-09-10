package com.example.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.core.network.RemoteDataSource
import com.example.core.network.Resource
import com.example.data.model.PlaylistsModel
import kotlinx.coroutines.Dispatchers

class Repository(private val remoteDataSource: RemoteDataSource) {

    fun getPlaylist(): LiveData<Resource<PlaylistsModel>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            emit(remoteDataSource.getPlaylists())
        }
    }

    fun getDetails(playlistId: String): LiveData<Resource<PlaylistsModel>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading())
            emit(remoteDataSource.getDetails(playlistId))
        }
    }

}