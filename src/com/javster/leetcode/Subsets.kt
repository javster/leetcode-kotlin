package com.javster.leetcode

fun main() {
    val subsets = Subsets().subsets(intArrayOf(1,2,3))
    subsets.forEach { subset ->
        subset.forEach {
            print(it)
        }
        println()
    }
}

class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        val newList = ArrayList<ArrayList<Int>>()
        nums.sort()

        for (i in nums) {
            val copy = ArrayList<ArrayList<Int>>().apply {
                newList.forEach {
                    this.add(ArrayList(it))
                }
            }
            copy.forEach {
                it.add(i)
            }
            copy.add(arrayListOf(i))
            newList.addAll(copy)
        }
        newList.add(arrayListOf())
        return newList
    }
}