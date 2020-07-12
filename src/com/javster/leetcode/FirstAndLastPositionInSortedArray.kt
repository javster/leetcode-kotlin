package com.javster.leetcode

fun main() {
    searchRange(intArrayOf(1), 1)
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf(-1, -1)
    var lo = 0
    val numSize = nums.size - 1
    var hi = numSize
    var found = false
    var m = 0
    while (lo <= hi) {
        m = (hi + lo) / 2
        if (nums[m] > target) {
            hi = m - 1
        }
        if (nums[m] < target) {
            lo = m + 1
        }
        if (nums[m] == target) {
            found = true
            break
        }
    }

    var left = -1
    var right = -1
    val foundIndex = m

    if (found) {
        lo = 0
        hi = foundIndex
        if (m > 0) {
            while (lo <= hi) {
                m = (hi + lo) / 2
                if (nums[m] == target) {
                    hi = m - 1
                } else if (nums[m] < target) {
                    lo = m + 1
                }
            }
        }

        left = lo
        lo = m
        hi = numSize

        if (m < numSize) {
            while (lo <= hi) {
                m = (hi + lo) / 2
                if (nums[m] == target) {
                    lo = m + 1
                } else if (nums[m] > target) {
                    hi = m - 1
                }
            }
        }
        right = hi

        return intArrayOf(left, right)
    }

    return intArrayOf(-1, -1)
}