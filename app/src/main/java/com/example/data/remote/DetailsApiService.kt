package com.example.data.remote

import com.example.data.model.PlaylistsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DetailsApiService {

    @GET("playlistItems")
    suspend fun getDetails(
        @Query("part") part: String,
        @Query("key") key: String,
        @Query("playlistId") playlistId: String,
        @Query("maxResults") maxResults: Int,
    ): Response<PlaylistsModel>
}