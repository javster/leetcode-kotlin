package com.javster.leetcode

fun main() {
    println(Solution().findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    println(Solution().findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
    println(
        Solution().findMedianSortedArrays(
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4),
            intArrayOf(1, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4)
        )
    )
}

class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var i1 = 0
        var i2 = 0
        val arr = ArrayList<Int>()
        while (i1 < nums1.size && i2 < nums2.size) {
            when {
                nums1[i1] < nums2[i2] -> {
                    arr.add(nums1[i1++])
                }
                nums1[i1] > nums2[i2] -> {
                    arr.add(nums2[i2++])
                }
                else -> {
                    arr.add(nums1[i1++])
                }
            }
        }
        for (i in i1 until nums1.size) arr.add(nums1[i])
        for (i in i2 until nums2.size) arr.add(nums2[i])
        if (arr.size % 2 == 1) return arr[arr.size / 2].toDouble()
        return ((arr[arr.size / 2] + arr[(arr.size / 2) - 1]) / 2f).toDouble()
    }
}