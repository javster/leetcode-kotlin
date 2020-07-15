package com.javster.leetcode

import kotlin.math.min

fun main() {
    AngleBetweenHandsOfAClock().apply {
        println(angleClock(12, 30))
        println(angleClock(3, 30))
        println(angleClock(3, 15))
        println(angleClock(4, 50))
        println(angleClock(12, 0))
        println(angleClock(1, 57))
    }
}

class AngleBetweenHandsOfAClock {
    fun angleClock(hour: Int, minutes: Int): Double {
        val h = if (hour < 12) hour else 0
        val hAngle = (h * 60 + minutes) / 2.toDouble()
        val mAngle = (minutes * 6).toDouble()
        return if (Math.abs(mAngle - hAngle) > 180)  180 - (Math.abs(hAngle - mAngle) - 180) else Math.abs(mAngle - hAngle)
    }
}