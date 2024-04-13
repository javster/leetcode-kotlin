package com.javster.leetcode.easy

fun searchInsert(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return 0
    var l = 0
    var r = nums.size - 1
    var q = 0
    while (l <= r) {
        q = (l + r) / 2
        if (nums[q] == target) {
            return q
        }
        if (nums[q] < target) {
            l = q + 1
        } else {
            r = q - 1
        }
    }
    return if (nums[q] > target) 0.coerceAtLeast(q - 1)
    else q + 1
}

fun main() {
    println(searchInsert(intArrayOf(1,3,5,6), 5))
    println(searchInsert(intArrayOf(1,3,5,6), 2))
    println(searchInsert(intArrayOf(1,3,5,6), 7))
}