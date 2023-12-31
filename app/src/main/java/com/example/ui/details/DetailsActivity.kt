package com.example.ui.details

import android.view.View
import android.widget.Toast
import com.example.core.base.BaseActivity
import com.example.core.network.Resource
import com.example.lesson3_m6.R
import com.example.lesson3_m6.databinding.ActivityDetailsBinding
import com.example.ui.playlists.PlaylistsAdapter
import com.example.utils.Constants
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailsActivity : BaseActivity<ActivityDetailsBinding, DetailsViewModel>() {
    override fun inflateViewBinding(): ActivityDetailsBinding =
        ActivityDetailsBinding.inflate(layoutInflater)

    override val viewModel: DetailsViewModel by viewModel()

    private val adapter = PlaylistsAdapter(get(),this::onItemClick)

    override fun initView() {
        super.initView()
        binding.recyclerView.adapter = adapter

        with(binding) {
            tvPlaylistName.text = intent.getStringExtra(Constants.TITLE_KEY)!!
            tvDescription.text = intent.getStringExtra(Constants.DESCRIPTION_KEY)!!
            tvNumberOfVideos.text = intent.getStringExtra(Constants.NUMBER_OF_VIDEOS_KEY)!!
        }
    }

    override fun initLiveData() {
        super.initLiveData()
        val playlistId: String = intent.getStringExtra(Constants.PLAYLIST_ID_KEY)!!
        viewModel.getDetails(playlistId).observe(this) { response ->
            when (response.status) {
                Resource.Status.SUCCESS -> {
                    adapter.setListModel(response.data?.items)
                    viewModel.loading.value = false
                    binding.layoutNoInternet.root.visibility = View.GONE
                }

                Resource.Status.ERROR -> {
                    Toast.makeText(this, getString(R.string.error), Toast.LENGTH_SHORT).show()
                    viewModel.loading.value = false
                }

                Resource.Status.LOADING -> {
                    Toast.makeText(this, getString(R.string.loading), Toast.LENGTH_SHORT).show()
                    viewModel.loading.value = true
                }
            }
        }

        viewModel.loading.observe(this) { status ->
            if (status) binding.progressBar.visibility = View.VISIBLE
            else binding.progressBar.visibility = View.GONE
        }
    }

    override fun initListener() {
        super.initListener()
        binding.btnBack.setOnClickListener {
            finish()

        }
        binding.layoutNoInternet.btnTryAgain.setOnClickListener {
            initLiveData()
        }
    }


    override fun checkInternetConnection() {
        super.checkInternetConnection()
        viewModel.isOnline(this).observe(this) { isOnline ->
            if (!isOnline) {
                binding.layoutNoInternet.root.visibility = View.VISIBLE
            }
        }
    }

    private fun onItemClick(playlistId: String, title: String, description: String, numberOfVideos: String) {

    }
}
