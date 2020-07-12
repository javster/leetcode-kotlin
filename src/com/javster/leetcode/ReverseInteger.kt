package com.javster.leetcode

fun main() {
    reverse(1534236469)
}

fun reverse(x: Int): Int {
    if (x == 0) return 0
    val x = x.toLong()
    val sign = x / Math.abs(x)
    val result = multiply(divide(Math.abs(x))) * sign
    println(result)
    return result.toInt()
}

fun divide(x: Long): ArrayList<Int> {
    val digits = ArrayList<Int>()
    var result: Long = x
    do {
        digits.add((result % 10).toInt())
        result /= 10
    } while (result > 0)
    return digits
}

fun multiply(digits: ArrayList<Int>): Int {
    var it = digits.iterator()
    while (it.hasNext()) {
        if (it.next() == 0) {
            it.remove()
        } else {
            break
        }
    }

    fun tenPow(pow: Int): Long {
        var result: Long = 1
        for (i in 0 until pow) {
            result *= 10
        }
        return result
    }

    var result: Long = 0
    for (i in 0 until digits.size) {
        result += digits[i] * tenPow(digits.size - i - 1)
    }

    if (result > Int.MAX_VALUE) {
        result = 0
    }

    return result.toInt()
}
