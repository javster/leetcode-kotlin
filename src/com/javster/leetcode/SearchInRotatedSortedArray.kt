package com.javster.leetcode

fun main() {
    val ss = SearchSolution()
    require(ss.search(intArrayOf(4,5,6,7,0,1,2), 0) == 4)
    require(ss.search(intArrayOf(4,5,6,7,0,1,2), 3) == -1)
    require(ss.search(intArrayOf(1), 0) == -1)
}

class SearchSolution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        val naturalDirection = target >= nums[0]
        var lastValue = nums[if (naturalDirection) 0 else nums.size - 1]
        for (i in if (naturalDirection) nums.indices else nums.indices.reversed()) {
            if (nums[i] == target) return i

            if (naturalDirection && nums[i] < lastValue) return -1
            else if (!naturalDirection && nums[i] > lastValue) return -1

            lastValue = nums[i]
        }
        return -1
    }
}