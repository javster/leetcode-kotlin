package com.javster.leetcode

fun maxProfit(prices: IntArray): Int {
    var profit = 0
    var min = Int.MAX_VALUE
    for (i in prices.indices) {
        val delta = prices[i] - min
        if (delta > profit) {
            profit = delta
        }
        if (prices[i] < min) {
            min = prices[i]
        }
    }
    return profit
}

fun main() {
    println(maxProfit(intArrayOf(7,1,5,3,6,4)))
    println(maxProfit(intArrayOf(7,6,4,3,1)))
    println(maxProfit(intArrayOf(22,30,7,2,1,3,6,4,7)))
    println(maxProfit(intArrayOf(22,30,7,2,1,3,6,4,35)))
    println(maxProfit(intArrayOf()))
}