package com.masorone.easycodemvvm

interface TimeTicker {

    fun start(callback: Callback, period: Long = 1000)

    fun stop()

    interface Callback {
        fun tick()
    }
}