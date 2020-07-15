package com.javster.leetcode

fun main() {
    val p = PrisonCellAfterNDays()
    println(printResult(p.prisonAfterNDays(intArrayOf(1, 0, 0, 1, 0, 0, 1, 0), 10000000)))
    println(printResult(p.prisonAfterNDays(intArrayOf(0, 1, 0, 1, 1, 0, 0, 1), 7)))
}

private fun printResult(result: IntArray) {
    result.forEach { print(it) }
}

class PrisonCellAfterNDays {
    fun prisonAfterNDays(cells: IntArray, N: Int): IntArray {
        var finalArray = cells.copyOf()
        for (i in 0 until if (N < 14) N else N % 14 + 14) {
            val tempArrayList = finalArray.copyOf()
            for (j in tempArrayList.indices) {
                if (j == 0 || j == tempArrayList.size - 1) {
                    tempArrayList[j] = 0
                } else {
                    tempArrayList[j] = if (finalArray[j - 1] == finalArray[j + 1]) 1 else 0
                }
            }
            finalArray = tempArrayList
        }
        return finalArray
    }
}