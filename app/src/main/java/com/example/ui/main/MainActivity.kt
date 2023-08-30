package com.example.ui.main


import androidx.lifecycle.ViewModelProvider
import com.example.lesson3_m6.databinding.ActivityMainBinding
import com.example.core.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override fun inflateViewBinding(): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun initializeViewModel(): MainViewModel =
        ViewModelProvider(this@MainActivity)[MainViewModel::class.java]

    private val adapter = PlayListAdapter()
    override fun initializeLiveData() {
        super.initializeLiveData()
        viewModel.playList.observe(this) {
            adapter.setList(it)
        }
    }

    override fun initializeView() {
        super.initializeView()
        binding.recyclerView.adapter = adapter
        viewModel.getPlayList()
    }
}