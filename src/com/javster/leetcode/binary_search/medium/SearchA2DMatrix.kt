package com.javster.leetcode.binary_search.medium

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty()) {
        return false
    }

    val m = matrix.size
    val n = matrix[0].size
    val l = m * n

    fun search(p: Int, r: Int): Int {
        if (p > r) return -1
        val q = (p + r) / 2
        val i = matrix[q / n][q % n]
        return if (i == target) q
        else if (target < i) search(0, q - 1)
        else search(q + 1, r)
    }

    return search(0, l - 1) > -1
}

fun main() {
    println(
        searchMatrix(
        arrayOf(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(10, 11, 16, 20),
            intArrayOf(23, 30, 34, 60)
        ), 3
    )
    )
    println(
        searchMatrix(
        arrayOf(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(10, 11, 16, 20),
            intArrayOf(23, 30, 34, 60)
        ), 13
    )
    )
}