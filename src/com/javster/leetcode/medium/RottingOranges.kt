package com.javster.leetcode.medium

fun orangesRotting(grid: Array<IntArray>): Int {
    data class Point(val i: Int, val j: Int, var isActive: Boolean = true)

    var rottenCounter = 0
    var orangesTotal = 0
    val rottenList = mutableListOf<Point>()
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                orangesTotal++
            }
            if (grid[i][j] == 2) {
                rottenList.add(Point(i, j))
                rottenCounter++
                orangesTotal++
            }
        }
    }

    var turnCounter = -1

    do {
        var newRottenCounter = 0
        val m = grid.size
        val n = grid[0].size
        val s = rottenList.size
        for (i in 0 until s) {
            val point = rottenList[i]
            if (point.isActive) {
                val i = point.i
                val j = point.j
                var isActive = false

                fun doRot(i: Int, j: Int) {
                    grid[i][j] = 2
                    newRottenCounter++
                    rottenCounter++
                    isActive = true
                    rottenList.add(Point(i, j))
                }

                if (i > 0 && grid[i - 1][j] == 1) {
                    doRot(i - 1, j)
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    doRot(i, j - 1)
                }
                if (i < m - 1 && grid[i + 1][j] == 1) {
                    doRot(i + 1, j)
                }
                if (j < n - 1 && grid[i][j + 1] == 1) {
                    doRot(i, j + 1)
                }
                point.isActive = isActive
            }
        }
        turnCounter++
    } while (newRottenCounter > 0)

    return if (orangesTotal == rottenCounter) turnCounter else -1
}

fun main() {
    println(orangesRotting(arrayOf(
        intArrayOf(2,1,1),
        intArrayOf(1,1,0),
        intArrayOf(0,1,1)
    )))
    println(orangesRotting(arrayOf(
        intArrayOf(2,1,1),
        intArrayOf(0,1,1),
        intArrayOf(1,0,1)
    )))
    println(orangesRotting(arrayOf(
        intArrayOf(0,2)
    )))
}