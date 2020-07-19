package com.javster.leetcode

import java.math.BigInteger

fun main() {
    PlusOne().plusOne(intArrayOf(1,2,3)).forEach {
        print("$it,")
    }

    println()

    PlusOne().plusOne(intArrayOf(1,0,2,4,5)).forEach {
        print("$it,")
    }

    println()

    PlusOne().plusOne(intArrayOf(9)).forEach {
        print("$it,")
    }

    println()

    PlusOne().plusOne(intArrayOf(9,9)).forEach {
        print("$it,")
    }

    println()

    PlusOne().plusOne(intArrayOf(9,8,7,6,5,4,3,2,1,0)).forEach {
        print("$it,")
    }

    println()

    PlusOne().plusOne(intArrayOf(6,1,4,5,3,9,0,1,9,5,1,8,6,7,0,5,5,4,3)).forEach {
        print("$it,")
    }
}

class PlusOne {
    fun plusOne(digits: IntArray): IntArray {
        var digitMultiplicator = BigInteger.ONE
        var number = BigInteger.ZERO
        val tenBI = BigInteger.valueOf(10L)
        for (i in digits.size - 1 downTo 0) {
            number += digitMultiplicator.multiply(BigInteger.valueOf(digits[i].toLong()))
            digitMultiplicator *= tenBI
        }
        digitMultiplicator /= tenBI

        var newNumber = number + BigInteger.ONE

        val result = ArrayList<Int>()
        while (digitMultiplicator > BigInteger.ZERO) {
            val element = (newNumber / digitMultiplicator).toInt()
            if (element == 10) {
                result.add(1)
                result.add(0)
            } else {
                result.add(element)
            }
            newNumber %= digitMultiplicator
            digitMultiplicator /= tenBI
        }

        return result.toIntArray()
    }
}