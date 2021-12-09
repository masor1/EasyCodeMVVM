package com.masorone.easycodemvvm

class Triangle(private var sideA: Int, private var sideB: Int, private var sideC: Int) {

    init {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            throw IllegalArgumentException("triangle sides cannot be on-positive")
        }
    }

    fun isRightTriangle(): Boolean {
        return sideA.square() + sideB.square() == sideC.square() ||
                sideA.square() + sideC.square() == sideB.square() ||
                sideC.square() + sideB.square() == sideA.square()
    }

}

private fun Int.square() = this * this