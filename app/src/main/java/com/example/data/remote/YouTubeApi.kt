package com.example.data.remote

import com.example.data.model.PlayListModel
import com.example.lesson3_m6.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApi {
    @GET("playlists")
    fun getPlaylists(
        @Query("part") part: String = "contentDetails, snippet",
        @Query("channelId") channelId: String = "UCjDwvpIhyfBGz4bbH8bcvUg",
        @Query("key") key: String = BuildConfig.API_KEY,
        @Query("maxResults") maxResults: Int = 10,
    ): Call<PlayListModel>
}