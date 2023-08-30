package com.example.data.remote

import com.example.lesson3_m6.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    var retrofit = Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).build()
    var api = retrofit.create(YouTubeApi::class.java)
}