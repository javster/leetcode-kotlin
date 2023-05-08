package com.javster.leetcode.dynamic_programming

fun uniquePaths(m: Int, n: Int): Int {
    val memo = hashMapOf<Pair<Int, Int>, Int>()

    fun pathfind(i: Int, j: Int): Int {
        if (i == m - 1 && j == n - 1) {
            return 1
        }
        if (memo.containsKey(Pair(i, j))) {
            return memo[Pair(i, j)]!!
        }
        var count = 0
        if (i < m - 1) {
            count += pathfind(i + 1, j)
        }
        if (j < n - 1) {
            count += pathfind(i, j + 1)
        }
        memo[Pair(i, j)] = count

        return count
    }

    return pathfind(0, 0)
}

fun main() {
    println(uniquePaths(m = 3, n = 7))
    println(uniquePaths(m = 3, n = 2))
    println(uniquePaths(m = 51, n = 9))
}