package com.javster.leetcode

fun main() {
    require(SolutionSubarraySum().subarraySum(intArrayOf(1, 1, 1), 2) == 2)
    require(SolutionSubarraySum().subarraySum(intArrayOf(1, 2, 1, 2, 1), 3) == 4)
}

class SolutionSubarraySum {
    fun subarraySum(nums: IntArray, k: Int): Int {
        if (nums.isEmpty()) {
            return 0
        }
        val map = HashMap<Int, Int>().apply {
            put(0, 1)
        }
        var sum = 0
        var arraysAmount = 0
        nums.forEach { i ->
            sum += i
            val previousHits = map[sum - k] ?: 0
                map[sum - k] = previousHits + 1
            arraysAmount += previousHits

            val sameSums = map[sum] ?: 0
            map[sum] = sameSums + 1
        }
        return arraysAmount
    }
}