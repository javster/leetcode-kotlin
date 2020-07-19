package com.javster.leetcode

fun main() {
    println(PowXN().myPow(2.toDouble(), -25))
}

class PowXN {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) return 1.toDouble()
        val half = myPow(x, n / 2)
        if (n % 2 == 0) {
            return half * half
        } else if (n > 0) {
            return x * half * half
        } else {
            return half * half / x
        }
    }
}


