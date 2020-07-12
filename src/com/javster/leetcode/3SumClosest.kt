package com.javster.leetcode

fun main() {
    require(threeSumClosest(intArrayOf(0, 2, 1, -3), 1) == 0)
    require(threeSumClosest(intArrayOf(1, 1, -1, -1, 3), -1) == -1)
    require(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1) == 2)
    require(threeSumClosest(intArrayOf(1, 1, -1, -1, 3), 3) == 3)
    require(threeSumClosest(intArrayOf(2, 4, 8, 16, 32, 64, 128), 82) == 82)
}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    if (nums.size < 3) return Int.MAX_VALUE
    nums.sort()

    var closestValue = nums[0] + nums[1] + nums[nums.size - 1]

    for (i in nums.indices) {
        var j = i + 1
        var k = nums.size - 1

        while (j < k) {
            val sum3 = nums[i] + nums[j] + nums[k]

            val delta = Math.abs(target - sum3)
            val closestDelta: Long = Math.abs((target - closestValue).toLong())

            when {
                sum3 == target -> return sum3
                sum3 < target -> {
                    j++
                }
                else -> {
                    k--
                }
            }
            if (delta < closestDelta) {
                closestValue = sum3
            }
        }
    }

    return closestValue
}
