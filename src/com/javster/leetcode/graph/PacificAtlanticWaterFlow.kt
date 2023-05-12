package com.javster.leetcode.graph

import java.util.ArrayDeque

fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
    if (heights.isEmpty()) {
        return emptyList()
    }
    val n = heights[0].size
    val m = heights.size

    val pacificReachability = Array(m) {
        Array<Boolean?>(n) {
            null
        }
    }

    val atlanticReachability = Array(m) {
        Array<Boolean?>(n) {
            null
        }
    }

    for (i in pacificReachability.indices) {
        pacificReachability[i][0] = true
    }

    for (j in pacificReachability[0].indices) {
        pacificReachability[0][j] = true
    }

    for (i in atlanticReachability.indices) {
        atlanticReachability[i][n - 1] = true
    }

    for (j in atlanticReachability[0].indices) {
        atlanticReachability[m - 1][j] = true
    }

    data class Point(val i: Int, val j: Int)

    val solutions = mutableSetOf<Point>()
    fun traverse(i: Int, j: Int) {
        if (pacificReachability[i][j] == true && atlanticReachability[i][j] == true) {
            solutions.add(Point(i, j))
            return
        }
        val reachable = ArrayDeque<Point>()
        reachable.addLast(Point(i, j))

        val visited = mutableSetOf<Point>()
        while (reachable.isNotEmpty()) {
            val p = reachable.removeLast()
            val pi = p.i
            val pj = p.j
            if (pacificReachability[pi][pj] == true && atlanticReachability[pi][pj] == true) {
                solutions.add(Point(i, j))
                pacificReachability[i][j] = true
                atlanticReachability[i][j] = true
                return
            }
            if (pacificReachability[pi][pj] == true) {
                pacificReachability[i][j] = true
            }
            if (atlanticReachability[pi][pj] == true) {
                atlanticReachability[i][j] = true
            }
            if (pacificReachability[i][j] == true && atlanticReachability[i][j] == true) {
                solutions.add(Point(i, j))
                return
            }
            visited.add(p)
            if (pi > 0 && heights[pi - 1][pj] <= heights[pi][pj]) {
                val np = Point(pi - 1, pj)
                if (!visited.contains(np)) {
                    reachable.addLast(np)
                }
            }
            if (pi < m - 1 && heights[pi + 1][pj] <= heights[pi][pj]) {
                val np = Point(pi + 1, pj)
                if (!visited.contains(np)) {
                    reachable.addLast(np)
                }
            }
            if (pj > 0 && heights[pi][pj - 1] <= heights[pi][pj]) {
                val np = Point(pi, pj - 1)
                if (!visited.contains(np)) {
                    reachable.addLast(np)
                }
            }
            if (pj < n - 1 && heights[pi][pj + 1] <= heights[pi][pj]) {
                val np = Point(pi, pj + 1)
                if (!visited.contains(np)) {
                    reachable.addLast(np)
                }
            }
        }
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            traverse(i, j)
        }
    }

    return solutions.fold(mutableListOf<MutableList<Int>>()) { ac, el ->
        val point = mutableListOf<Int>()
        point.add(el.i)
        point.add(el.j)
        ac.add(point)
        ac
    }

}

fun main() {
    val r = pacificAtlantic(
        arrayOf(
            intArrayOf(1, 2, 2, 3, 5),
            intArrayOf(3, 2, 3, 4, 4),
            intArrayOf(2, 4, 5, 3, 1),
            intArrayOf(6, 7, 1, 4, 5),
            intArrayOf(5, 1, 1, 2, 4)
        )
    )
    println(r)
}