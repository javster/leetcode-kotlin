package com.javster.leetcode
fun main() {
    val instance = FindMinimumInRotatedSortedArrayII()
    with(instance) {
        println(findMin(intArrayOf(4,5,6,7,0,1,2)))
        println(findMin(intArrayOf(4,5,6,6,6,6,6,7,7,7,0,1,1,1,1,1,1,2)))
        println(findMin(intArrayOf(1,2,3,4,5,6,7,8,9,10,255)))
        println(findMin(intArrayOf(3,1)))
        println(findMin(intArrayOf(3,1,1)))
        println(findMin(intArrayOf(2,2,2,0,1)))
        println(findMin(intArrayOf(3,1,3)))
        println(findMin(intArrayOf(1,3,1,1)))
        println(findMin(intArrayOf(10,1,10,10,10)))
        println(findMin(intArrayOf(3,3,3,3,3,3,3,3,1,3)))
    }
}

class FindMinimumInRotatedSortedArrayII {

    fun findMin(nums: IntArray): Int {
        val removedDups = nums.toSortedSet().toIntArray()
        if (removedDups[0] < removedDups[removedDups.size - 1]) return removedDups[0]
        var left = 0
        var right = removedDups.size - 1
        val delimiter = removedDups[0]
        var lastLeftBigger = left
        while (left < right) {
            val pos = left + (right - left) / 2
            if (removedDups[pos] < delimiter) {
                right = pos
            } else {
                lastLeftBigger = pos
                left = pos + 1
            }
            if (left < right) {
                if (removedDups[left] < delimiter && removedDups[right] < delimiter) {
                    right = left
                    left = lastLeftBigger
                } else if (removedDups[left] > delimiter && removedDups[right] > delimiter) {
                    right = left - 1
                    left = 0
                }
                if (removedDups[left] < removedDups[right]) return removedDups[left]
            }
        }

        return removedDups[right]
    }
}