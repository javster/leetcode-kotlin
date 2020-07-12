package com.javster.leetcode

fun main() {
    ThreeSum().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
}

class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return emptyList()
        nums.sort()
        val result = ArrayList<ArrayList<Int>>()

        for (i in nums.indices) {
            var j = i + 1
            var k = nums.size - 1

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            while (j < k) {
                if (k < nums.size - 1 && nums[k] == nums[k + 1]) {
                    k--
                    continue
                }

                val sum3 = nums[i] + nums[j] + nums[k]
                when {
                    sum3 > 0 -> {
                        k--
                    }
                    sum3 < 0 -> {
                        j++
                    }
                    else -> {
                        result.add(arrayListOf(nums[i], nums[j], nums[k]).apply { sort() })
                        k--
                        j++
                    }
                }
            }
        }

        return result.distinct()
    }
}