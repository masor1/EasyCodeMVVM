package com.masorone.easycodemvvm

import android.app.Application
import com.masorone.easycodemvvm.data.CacheDataSource

class MyApplication : Application() {

    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        viewModel = MainViewModel(Model(CacheDataSource(this), TimerTicker()))
    }
}