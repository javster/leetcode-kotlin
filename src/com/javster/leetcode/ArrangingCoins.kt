package com.javster.leetcode

fun main() {
    println(ArrangingCoins().arrangeCoins(3))
    println(ArrangingCoins().arrangeCoins(5))
    println(ArrangingCoins().arrangeCoins(8))
}

class ArrangingCoins {
    fun arrangeCoins(n: Int): Int {
        var row = 0
        var total = n
        do {
            val res = substractCoins(row, total)
            total = res.second
            if (res.first) row++
        } while (res.first)
        return row
    }

    private fun substractCoins(row: Int, total: Int): Pair<Boolean, Int> = if (total < row + 1) Pair(false, 0)
    else Pair(true, total - (row + 1))
}