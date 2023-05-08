package com.javster.leetcode.dynamic_programming

import kotlin.math.min

fun minCostClimbingStairs(cost: IntArray): Int {
    val n = cost.size
    val cache = mutableMapOf<Int, Int>()

    fun recursiveCost(i: Int): Int {
        if (i >= n - 2) {
            return if (i < n) {
                cost[i]
            } else {
                0
            }
        }
        val price = if (cache.contains(i)) {
            cache[i]
        } else {
            val stepCost = if (i < 0) 0 else cost[i]
            stepCost + min(recursiveCost(i + 1), recursiveCost(i + 2))
        }
        cache[i] = price!!
        return price
    }

    return recursiveCost(-1)
}

fun main() {
    println(minCostClimbingStairs(intArrayOf(10, 15, 20)))
    println(minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
}