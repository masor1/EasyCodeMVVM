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

    @Test
    fun test_start_with_saved_value() {
        val testDataSource = TestDataSource()
        val model = Model(testDataSource)
        val callback = TestCallback()
        testDataSource.saveInt("", 5)
        model.start(callback)
        Thread.sleep(10)
        val actual = callback.text
        val expected = "6"
        assertEquals(expected, actual)
    }

    @Test
    fun test_stop_after_2_seconds() {
        val testDataSource = TestDataSource()
        val model = Model(testDataSource)
        val callback = TestCallback()
        testDataSource.saveInt("", 0)
        model.start(callback)
        Thread.sleep(2000)
        val actual = callback.text
        val expected = "2"
        assertEquals(expected, actual)
        model.stop()
        val savedCountActual = testDataSource.getInt("")
        val savedCountExpected = 2
        assertEquals(savedCountExpected, savedCountActual)
    }
}