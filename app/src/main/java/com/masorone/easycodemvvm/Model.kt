package com.masorone.easycodemvvm

import android.util.Log
import com.masorone.easycodemvvm.data.DataSource
import java.util.*

class Model(
    private val dataSource: DataSource,
    private val timeTicker: TimeTicker
    ) {

    private val tickerCallback
    get() = object : TimeTicker.Callback {
        override fun tick() {
            count++
            textCallback?.updateText(count.toString())
        }
    }

    private var textCallback: TextCallback? = null
    private var count = -1


    fun start(textCallback: TextCallback) {
        this.textCallback = textCallback
        if (count < 0)
            count = dataSource.getInt(COUNTER_KEY)
        timeTicker.start(tickerCallback)
    }

    fun stop() {
        dataSource.saveInt(COUNTER_KEY, count)
        timeTicker.stop()
        textCallback = null
    }

    companion object {
        private const val COUNTER_KEY = "counterKey"
    }
}