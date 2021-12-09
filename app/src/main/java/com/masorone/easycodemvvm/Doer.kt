package com.masorone.easycodemvvm

import android.util.Log

class Doer(private val logger: Logging){

    private var mainThingDone = false

    fun doMain() {
        if (!mainThingDone) {
            logger.log("main thing done")
            mainThingDone = true
        }
    }
}

interface Logging {
    fun log(message: String)
}
