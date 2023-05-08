package com.javster.leetcode.easy

fun isHappy(n: Int): Boolean {
    val alreadyFoundDigits = mutableListOf<Int>()
    var value = n
    while (value != 1) {
        val array = value.toString().toByteArray().map { it - 48 }
        value = array.fold(0) { acc, i ->
            acc + i * i
        }
        if (alreadyFoundDigits.contains(value)) {
            break
        }
        alreadyFoundDigits.add(value)
    }
    return value == 1
}

fun main() {
    println(isHappy(19))
    println(isHappy(2))
}
