package com.javster.leetcode.heap

import java.util.SortedSet

fun lastStoneWeight(stones: IntArray): Int {
    if (stones.isEmpty()) {
        return 0
    }

    if (stones.size == 1) {
        return stones[0]
    }

    val a = mutableListOf<Int>()
    stones.forEach {
        a.add(it)
    }

    do {
        a.sortDescending()
        a[0] = a[0] - a[1]
        a.removeAt(1)
    } while (a.size > 1)

    return a[0]
}

fun main() {
    println(lastStoneWeight(intArrayOf(2,7,4,1,8,1)))
    println(lastStoneWeight(intArrayOf(1)))
}