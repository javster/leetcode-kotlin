package com.javster.leetcode

fun main() {
    val searchSolution = SearchSolution()
    require(searchSolution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0) == 4)
    require(searchSolution.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3) == -1)
    require(searchSolution.search(intArrayOf(1), 0) == -1)
    require(searchSolution.search(intArrayOf(1, 3), 0) == -1)
}

class SearchSolution {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return -1
        var pivot: Int = -1
        if (nums[0] > nums[nums.size - 1]) {
            var p = 0
            var r = nums.size - 1
            while (p <= r) {
                pivot = (p + r) / 2
                if (nums[pivot] > nums[nums.size - 1]) {
                    p = pivot + 1
                    r = nums.size - 1
                } else {
                    r = pivot - 1
                }
            }
        }

        var p: Int
        var r: Int
        if (pivot > -1) {
            if (target >= nums[pivot] && target <= nums[nums.size - 1]) {
                p = pivot
                r = nums.size - 1
            } else {
                p = 0
                r = pivot - 1
            }
        } else {
            p = 0
            r = nums.size - 1
        }

        val lower: Int = p
        val upper: Int = r

        while (p <= r) {
            val q = (p + r) / 2
            if (nums[q] == target) {
                return q
            } else if (nums[q] > target) {
                p = lower
                r = q - 1
            } else {
                p = q + 1
                r = upper
            }
        }
        return -1
    }
}