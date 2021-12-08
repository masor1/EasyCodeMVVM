package com.masorone.easycodemvvm.data

import android.content.Context
import android.content.Context.MODE_PRIVATE

class CacheDataSource(context: Context) : DataSource {

    private val sharedPreferences = context.getSharedPreferences("counting", MODE_PRIVATE)

    override fun saveInt(key: String, value: Int) = sharedPreferences.edit().putInt(key, value).apply()
    override fun getInt(key: String) = sharedPreferences.getInt(key, 0)
}