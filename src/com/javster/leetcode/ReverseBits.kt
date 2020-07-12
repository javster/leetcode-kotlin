package com.javster.leetcode

fun main() {
    println(ReverseBits().reverseBits(0b00000010100101000001111010011100))
    println(ReverseBits().reverseBits(4294967293.toInt()))
}

class ReverseBits {

    fun reverseBits(n: Int): Int {
        var newInt = 0
        repeat(32) { bitNumber ->
            newInt += (n shr bitNumber) and (1 shl 32 - 1 - bitNumber)
        }
        return newInt
    }
}