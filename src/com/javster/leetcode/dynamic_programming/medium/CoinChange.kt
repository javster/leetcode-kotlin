//package com.javster.leetcode.dynamic_programming.medium
//
//fun coinChange(coins: IntArray, amount: Int): Int {
//    val n = coins.size
//    if (n == 0) {
//        return -1
//    }
//
//    coins.sort()
//
//    var s = 0
//    var i = n - 1
//    while (s < amount && i >= 0) {
//        if (coins[i] > amount) {
//            i--
//        }
//    }
//
//}