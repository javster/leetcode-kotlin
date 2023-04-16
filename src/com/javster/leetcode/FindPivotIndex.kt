package com.javster.leetcode

class FindPivotIndex {
    fun pivotIndex(nums: IntArray): Int {
        val lastIndex = nums.size - 1

        if (nums.size == 1) {
            return 0
        }

        val leftToRight = IntArray(nums.size)
        var sum = 0
        nums.forEachIndexed { index, i ->
            sum += i
            leftToRight[index] = sum
        }

        sum = 0

        var leftmostIndex = -1
        nums.reversed().forEachIndexed { index, i ->
            sum += i
            val mirrorIndex = lastIndex - index - 2
            if (mirrorIndex >= 0) {
                if (sum == leftToRight[mirrorIndex]) {
                    leftmostIndex = mirrorIndex + 1
                }
            } else if (mirrorIndex == -1 && sum == 0) {
                //Left to right zero-sum edge case
                leftmostIndex = 0
            }
        }

        if (leftmostIndex == -1) {
            if (lastIndex >= 2 && leftToRight[lastIndex - 1] == 0) {
                //Right to left zero-sum edge case
                return lastIndex
            }
        }

        return leftmostIndex
    }

    fun pivotIndex2(nums: IntArray): Int {
        // Initialize total sum of the given array...
        var totalSum = 0
        // Initialize 'leftsum' as sum of first i numbers, not including nums[i]...
        var leftsum = 0
        // Traverse the elements and add them to store the totalSum...
        for (ele in nums) totalSum += ele
        // Again traverse all the elements through the for loop and store the sum of i numbers from left to right...
        var i = 0
        while (i < nums.size) {
            // sum to the left == leftsum.
            // sum to the right === totalSum - leftsum - nums[i]..
            // check if leftsum == totalSum - leftsum - nums[i]...
            if (leftsum * 2 == totalSum - nums[i]) return i // Return the pivot index...
            leftsum += nums[i++]
        }
        return -1 // If there is no index that satisfies the conditions in the problem statement...
    }
}

fun main() {
    val findPivotIndex = FindPivotIndex()
    println(findPivotIndex.pivotIndex(intArrayOf(1,7,3,6,5,6)))
    println(findPivotIndex.pivotIndex(intArrayOf(1,2,3)))
    println(findPivotIndex.pivotIndex(intArrayOf(2,1,-1)))
    println(findPivotIndex.pivotIndex(intArrayOf(1,-1,2)))
    println(findPivotIndex.pivotIndex(intArrayOf(-1,-1,0,0,-1,-1)))
    println(findPivotIndex.pivotIndex(intArrayOf(-1,-1,0,1,1,-1)))
    println(findPivotIndex.pivotIndex(intArrayOf(-1,-1,0,1,1,0)))
    println(findPivotIndex.pivotIndex(intArrayOf(5)))

    println()

    println(findPivotIndex.pivotIndex2(intArrayOf(1,7,3,6,5,6)))
    println(findPivotIndex.pivotIndex2(intArrayOf(1,2,3)))
    println(findPivotIndex.pivotIndex2(intArrayOf(2,1,-1)))
    println(findPivotIndex.pivotIndex2(intArrayOf(1,-1,2)))
    println(findPivotIndex.pivotIndex2(intArrayOf(-1,-1,0,0,-1,-1)))
    println(findPivotIndex.pivotIndex2(intArrayOf(-1,-1,0,1,1,-1)))
    println(findPivotIndex.pivotIndex2(intArrayOf(-1,-1,0,1,1,0)))
    println(findPivotIndex.pivotIndex2(intArrayOf(5)))
}