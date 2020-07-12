package com.javster.leetcode

class Contiguous {
    fun findMaxLength(nums: IntArray): Int {
        var longest = 0
        val sumsMap = HashMap<Int, Int>().apply {
            this[0] = -1
        }
        var currentSum = 0
        for (i in 0 until nums.size) {
            currentSum += if (nums[i] == 0) -1 else 1
            if (sumsMap.containsKey(currentSum)) {
                longest = longest.coerceAtLeast(i - sumsMap[currentSum]!!)
            } else {
                sumsMap[currentSum] = i
            }
        }

        return longest
    }
}