package com.javster.leetcode

val firstGrid = arrayOf(
    intArrayOf(1, 3, 1),
    intArrayOf(1, 5, 1),
    intArrayOf(4, 2, 1)
)

val secondGrid = arrayOf(
    intArrayOf(1, 2, 3),
    intArrayOf(4, 5, 6)
)

val bigGrid = arrayOf(
    intArrayOf(7, 1, 3, 5, 8, 9, 9, 2, 1, 9, 0, 8, 3, 1, 6, 6, 9, 5),
    intArrayOf(9, 5, 9, 4, 0, 4, 8, 8, 9, 5, 7, 3, 6, 6, 6, 9, 1, 6),
    intArrayOf(8, 2, 9, 1, 3, 1, 9, 7, 2, 5, 3, 1, 2, 4, 8, 2, 8, 8),
    intArrayOf(6, 7, 9, 8, 4, 8, 3, 0, 4, 0, 9, 6, 6, 0, 0, 5, 1, 4),
    intArrayOf(7, 1, 3, 1, 8, 8, 3, 1, 2, 1, 5, 0, 2, 1, 9, 1, 1, 4),
    intArrayOf(9, 5, 4, 3, 5, 6, 1, 3, 6, 4, 9, 7, 0, 8, 0, 3, 9, 9),
    intArrayOf(1, 4, 2, 5, 8, 7, 7, 0, 0, 7, 1, 2, 1, 2, 7, 7, 7, 4),
    intArrayOf(3, 9, 7, 9, 5, 8, 9, 5, 6, 9, 8, 8, 0, 1, 4, 2, 8, 2),
    intArrayOf(1, 5, 2, 2, 2, 5, 6, 3, 9, 3, 1, 7, 9, 6, 8, 6, 8, 3),
    intArrayOf(5, 7, 8, 3, 8, 8, 3, 9, 9, 8, 1, 9, 2, 5, 4, 7, 7, 7),
    intArrayOf(2, 3, 2, 4, 8, 5, 1, 7, 2, 9, 5, 2, 4, 2, 9, 2, 8, 7),
    intArrayOf(0, 1, 6, 1, 1, 0, 0, 6, 5, 4, 3, 4, 3, 7, 9, 6, 1, 9)
)

val bigGrid2 = arrayOf(
    intArrayOf(7, 1, 3, 5, 8, 9, 9, 2, 1, 9, 0, 8, 3, 1, 6, 6, 9, 5),
    intArrayOf(9, 5, 9, 4, 0, 4, 8, 8, 9, 5, 7, 3, 6, 6, 6, 9, 1, 6),
    intArrayOf(8, 2, 9, 1, 3, 1, 9, 7, 2, 5, 3, 1, 2, 4, 8, 2, 8, 8),
    intArrayOf(6, 7, 9, 8, 4, 8, 3, 0, 4, 0, 9, 6, 6, 0, 0, 5, 1, 4),
    intArrayOf(7, 1, 3, 1, 8, 8, 3, 1, 2, 1, 5, 0, 2, 1, 9, 1, 1, 4),
    intArrayOf(9, 5, 4, 3, 5, 6, 1, 3, 6, 4, 9, 7, 0, 8, 0, 3, 9, 9),
    intArrayOf(1, 4, 2, 5, 8, 7, 7, 0, 0, 7, 1, 2, 1, 2, 7, 7, 7, 4),
    intArrayOf(3, 9, 7, 9, 5, 8, 9, 5, 6, 9, 8, 8, 0, 1, 4, 2, 8, 2),
    intArrayOf(1, 5, 2, 2, 2, 5, 6, 3, 9, 3, 1, 7, 9, 6, 8, 6, 8, 3),
    intArrayOf(5, 7, 8, 3, 8, 8, 3, 9, 9, 8, 1, 9, 2, 5, 4, 7, 7, 7)
)

fun main() {
    require(minPathSum(firstGrid) == 7)
    require(minPathSum(secondGrid) == 12)

}

fun minPathSum(grid: Array<IntArray>): Int {
    if (grid.isEmpty()) return 0
    val resultArray = Array(grid.size) { IntArray(grid[0].size) }

    for (i in grid.indices) {
        for (j in grid[0].indices) {
            resultArray[i][j] += grid[i][j]
            if (i > 0 && j > 0) {
                resultArray[i][j] += Math.min(resultArray[i - 1][j], resultArray[i][j - 1])
            } else if (j > 0) {
                resultArray[i][j] += resultArray[i][j - 1]
            } else if (i > 0) {
                resultArray[i][j] += resultArray[i - 1][j]
            }
        }
    }
    return resultArray[grid.size - 1][grid[0].size - 1]
}
