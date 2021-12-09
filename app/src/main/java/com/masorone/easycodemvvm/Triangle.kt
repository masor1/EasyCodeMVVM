package com.masorone.easycodemvvm

class Triangle(private var sideA: Int, private var sideB: Int, private var sideC: Int) {

    fun isRightTriangle(): Boolean {
        return sideA.square() + sideB.square() == sideC.square() ||
                sideA.square() + sideC.square() == sideB.square() ||
                sideC.square() + sideB.square() == sideA.square()
    }

}

private fun Int.square() = this * this