package com.javster.leetcode

import java.math.BigInteger

fun main() {
    println(AddBinary().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"))

}

class AddBinary {
    fun addBinary(a: String, b: String): String {
        return bitsToString(binaryToDecimal(a) + binaryToDecimal(b))
    }

    fun binaryToDecimal(s: String): BigInteger {
        var order = s.length - 1
        var sum = BigInteger.ZERO
        for (c in s) {
            val i = BigInteger.valueOf(c.toLong() - 48)
            sum += i shl order
            order--
        }
        return sum
    }

    fun bitsToString(i: BigInteger): String {
        var c = i
        val sb = StringBuilder()
        do {
            sb.append(c and BigInteger.ONE)
            c = c shr 1
        } while (c > BigInteger.ZERO)
        return sb.reverse().toString()
    }
}