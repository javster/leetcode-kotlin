package com.javster.leetcode.easy

fun search(nums: IntArray, target: Int): Int {
    var p = 0
    var r = nums.size - 1
    while (p <= r) {
        val q = (r + p) / 2
        if (nums[q] == target) {
            return q
        } else if (nums[q] > target) {
            r = q - 1
        } else if (nums[q] < target) {
            p = q + 1
        }
    }
    return -1
}

fun main() {
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 9))
    println(search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
    println(search(intArrayOf(1, 1, 1), 1))
    println(search(intArrayOf(1, 2, 3), 1))

}