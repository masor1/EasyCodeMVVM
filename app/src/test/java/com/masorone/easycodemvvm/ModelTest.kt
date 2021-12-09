package com.masorone.easycodemvvm

import com.masorone.easycodemvvm.data.TestDataSource
import org.junit.Assert.*
import org.junit.Test

class ModelTest {

    private class TestCallback : TextCallback {
        var text = ""
        override fun updateText(str: String) {
            text = str
        }
    }

    private class TestTimeTicker : TimeTicker {

        private var callback: TimeTicker.Callback? = null

        var state = 0

        override fun start(callback: TimeTicker.Callback, period: Long) {
            this.callback = callback
            state = 1
        }

        override fun stop() {
            callback = null
            state = -1
        }

        fun tick(times: Int) {
            for (i in 0 until times)
                callback?.tick()
        }
    }

    @Test
    fun test_start_with_saved_value() {
        val testDataSource = TestDataSource()
        val timerTicker = TestTimeTicker()
        val model = Model(testDataSource, timerTicker)
        val callback = TestCallback()
        testDataSource.saveInt("", 5)
        model.start(callback)
        timerTicker.tick(1)
        val actual = callback.text
        val expected = "6"
        assertEquals(expected, actual)
    }

    @Test
    fun test_stop_after_2_seconds() {
        val testDataSource = TestDataSource()
        val timeTicker = TestTimeTicker()
        val model = Model(testDataSource, timeTicker)
        val callback = TestCallback()
        testDataSource.saveInt("", 0)
        model.start(callback)
        timeTicker.tick(2)
        val actual = callback.text
        val expected = "2"
        assertEquals(expected, actual)

        model.stop()
        val savedCountActual = testDataSource.getInt("")
        val savedCountExpected = 2
        assertEquals(savedCountExpected, savedCountActual)
    }
}