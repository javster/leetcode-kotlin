package com.javster.leetcode.dynamic_programming.medium

fun rob(nums: IntArray): Int {
    val memo = Array<Int?>(nums.size) {
        null
    }

    fun profit(i: Int): Int {
        return if (i >= nums.size) 0
        else if (i == nums.size - 1) nums[i]
        else {
            if (memo[i] != null) {
                memo[i]!!
            } else {
                val p = Math.max(nums[i] + profit(i + 2), nums[i + 1] + profit(i + 3))
                memo[i] = p
                p
            }
        }
    }

    return profit(0)
}

fun main() {
    println(rob(intArrayOf(1, 2, 3, 1)))
    println(rob(intArrayOf(2, 7, 9, 3, 1)))
}