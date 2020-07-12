package com.javster.leetcode

fun main() {
    println(HammingDistance().hammingDistance(1, 4))
}

class HammingDistance {
    fun hammingDistance(x: Int, y: Int): Int {
        var reminder = x xor y
        var distance = 0
        do {
            if (reminder % 2 == 1) {
                distance++
            }
            reminder /= 2
        } while (reminder > 0)
        return distance
    }
}