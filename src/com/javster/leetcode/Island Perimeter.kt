package com.javster.leetcode

fun main() {
    val testWorld = arrayOf(intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 1, 1, 0),
            intArrayOf(0, 1, 0, 0),
            intArrayOf(1, 1, 0, 0))

    println(IslandPerimeter().islandPerimeter(testWorld))
}

class IslandPerimeter {

    fun islandPerimeter(grid: Array<IntArray>): Int {
        var perimeter = 0
        for (i in grid.indices) {
            for (j in grid[i].indices) {
                if (grid[i][j] == 1) {
                    if (i == 0) perimeter++ else {
                        if (grid[i - 1][j] == 0) perimeter++
                    }
                    if (i == grid.size - 1) perimeter++ else {
                        if (grid[i + 1][j] == 0) perimeter++
                    }
                    if (j == 0) perimeter++ else {
                        if (grid[i][j - 1] == 0) perimeter++
                    }
                    if (j == grid[i].size - 1) perimeter++ else {
                        if (grid[i][j + 1] == 0) perimeter++
                    }
                }

            }
        }
        return perimeter
    }
}