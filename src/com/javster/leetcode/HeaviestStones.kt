package com.javster.leetcode

fun main() {
    println(HeaviestStones().lastStoneWeight(intArrayOf(2,2)))
}

class HeaviestStones {

    fun lastStoneWeight(stones: IntArray): Int {
        if (stones.isEmpty()) return 0
        if (stones.size == 1) return stones[0]
        stones.sortDescending()
        val list = stones.toMutableList()
        while (list.size > 1) {
            val result = Math.abs(list[0] - list[1])
            list.removeAt(0)
            list.removeAt(0)
            if (result > 0) {
                list.add(result)
            }
            list.sortDescending()
        }
        return if (list.size > 0) list[0] else 0
    }
}