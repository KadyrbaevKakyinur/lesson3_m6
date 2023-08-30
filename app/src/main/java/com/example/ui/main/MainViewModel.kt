package com.example.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.base.BaseViewModel
import com.example.data.model.PlayListModel
import com.example.data.remote.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : BaseViewModel() {
    private var _playList: MutableLiveData<PlayListModel> = MutableLiveData<PlayListModel>()
    val playList: LiveData<PlayListModel> = _playList
    fun getPlayList() {
        RetrofitService.api.getPlaylists().enqueue(object : Callback<PlayListModel> {
            override fun onResponse(
                call: Call<PlayListModel>, response: Response<PlayListModel>
            ) {
                if (response.isSuccessful) {
                    _playList.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<PlayListModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message.toString()}")
            }
        })
    }
}