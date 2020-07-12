package com.javster.leetcode.utils

fun main() {
    0b00000010100101000001111010011100.printBits()
}

fun Int.printBits() {
    val chars = IntArray(32)
    repeat(32) { bitNumber ->
        chars[32 - 1 - bitNumber] = this shr bitNumber and 1
    }
    chars.forEach {
        print(it)
    }
}