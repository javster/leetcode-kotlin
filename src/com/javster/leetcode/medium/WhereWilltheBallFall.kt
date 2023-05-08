package com.javster.leetcode.medium

fun findBall(grid: Array<IntArray>): IntArray {
    if (grid.isEmpty()) {
        return intArrayOf()
    }
    val n = grid.size
    val m = grid[0].size
    val results = IntArray(m)
    for (col in 0 until m) {
        var j = col
        var i = 0
        while (j > -1 && i < n) {
            val board = grid[i][j]
            val neighbour = j + board
            if (neighbour == m || neighbour == -1 || grid[i][neighbour] == -board) {
                j = -1
                break
            }

            j += board
            i++
        }
        results[col] = j
    }
    return results
}

fun main() {
    findBall(
        arrayOf(
            intArrayOf(1, 1, 1, -1, -1),
            intArrayOf(1, 1, 1, -1, -1),
            intArrayOf(-1, -1, -1, 1, 1),
            intArrayOf(1, 1, 1, 1, -1),
            intArrayOf(-1, -1, -1, -1, -1)
        )
    ).forEach { print("$it ") }

    println()

    findBall(
        arrayOf(
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(-1, -1, -1, -1, -1, -1),
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(-1, -1, -1, -1, -1, -1)
        )
    ).forEach { print("$it ") }
}
