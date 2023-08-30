package com.example.core.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding, VM : ViewModel> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected lateinit var viewModel: VM
    protected abstract fun inflateViewBinding(): VB
    protected abstract fun initializeViewModel(): VM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding()
        setContentView(binding.root)
        viewModel = initializeViewModel()
        checkInternetConnection()
        initializeView()
        initializeLiveData()
        initializeListener()
    }

    open fun initializeListener() {}
    open fun initializeLiveData() {}
    open fun initializeView() {}
    open fun checkInternetConnection() {}
}