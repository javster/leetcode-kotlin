package com.javster.leetcode

fun maximumWealth(accounts: Array<IntArray>): Int {
    var richestSum = 0
    for (i in accounts.indices) {
        var accountSum = 0
        for (j in accounts[i].indices) {
            accountSum += accounts[i][j]
        }
        if (accountSum > richestSum) {
            richestSum = accountSum
        }
    }
    return richestSum
}

fun main() {
    println(maximumWealth(arrayOf(intArrayOf(1,2,3), intArrayOf(3,2,1))))
    println(maximumWealth(arrayOf(intArrayOf(1,5), intArrayOf(7,3), intArrayOf(3,5))))
}