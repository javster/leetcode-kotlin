package com.javster.leetcode

fun main() {
    println(AddDigits().addDigits(38))
}

class AddDigits {
    fun addDigits(num: Int): Int {
        if (singleDigit(num)) {
            return num
        }
        return addDigits(splitIntoDigits(num))
    }

    fun splitIntoDigits(num: Int): Int {
        var reminder = num
        var divisor = 10
        var sum = 0
        while (reminder > 0) {
            sum += reminder % divisor
            reminder /= divisor
            divisor *= 10
        }
        return sum
    }

    fun singleDigit(i: Int) =
        i.toString().length == 1
}