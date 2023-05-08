package com.javster.leetcode.medium

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if (matrix.isEmpty()) {
        return emptyList()
    }
    val n = matrix.size
    val m = matrix[0].size
    val count = n * m
    val visitList = mutableListOf<Int>()
    val alreadyVisited = Array(n) {
        BooleanArray(m)
    }
    var visited = 0
    var direction = Direction.RIGHT
    var i = 0
    var j = -1
    while (visited < count) {
        when (direction) {
            Direction.RIGHT -> {
                if (j < m - 1 && !alreadyVisited[i][j + 1]) {
                    alreadyVisited[i][++j] = true
                    visitList.add(matrix[i][j])
                    visited++
                } else {
                    direction = Direction.DOWN
                }
            }

            Direction.DOWN -> {
                if (i < n - 1 && !alreadyVisited[i + 1][j]) {
                    alreadyVisited[++i][j] = true
                    visitList.add(matrix[i][j])
                    visited++
                } else {
                    direction = Direction.LEFT
                }
            }

            Direction.LEFT -> if (j > 0 && !alreadyVisited[i][j - 1]) {
                alreadyVisited[i][--j] = true
                visitList.add(matrix[i][j])
                visited++
            } else {
                direction = Direction.UP
            }

            Direction.UP -> {
                if (i > 0 && !alreadyVisited[i - 1][j]) {
                    alreadyVisited[--i][j] = true
                    visitList.add(matrix[i][j])
                    visited++
                } else {
                    direction = Direction.RIGHT
                }
            }
        }
    }

    return visitList
}

enum class Direction {
    RIGHT,
    DOWN,
    LEFT,
    UP
}

fun main() {
    spiralOrder(arrayOf(
        intArrayOf(1,2,3,4),
        intArrayOf(5,6,7,8),
        intArrayOf(9,10,11,12)
    )).forEach { print("$it ") }
}