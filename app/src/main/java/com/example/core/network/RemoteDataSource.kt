package com.example.core.network

import com.example.core.base.BaseDataSource
import com.example.data.remote.DetailsApiService
import com.example.data.remote.PlaylistsApiService
import com.example.lesson3_m6.BuildConfig
import com.example.utils.Constants


class RemoteDataSource(private val playlistsApiService: PlaylistsApiService, private val detailsApiService: DetailsApiService) : BaseDataSource() {

    suspend fun getPlaylists() = getResult {
        playlistsApiService.getPlaylists(
            key = BuildConfig.API_KEY,
            part = Constants.PART,
            channelId = Constants.CHANNEL_ID,
            maxResults = 10,
        )
    }
    suspend fun getDetails(playlistId: String) = getResult {
        detailsApiService.getDetails(
            key = BuildConfig.API_KEY,
            part = Constants.PART,
            playlistId = playlistId,
            maxResults = 10,
        )
    }
}
