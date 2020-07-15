package com.javster.leetcode

fun main() {
    println(UniqueBinarySearchTree().numTrees(11))
}

class UniqueBinarySearchTree {

    fun numTrees(n: Int): Int {
        return catalan(n)
    }

    private fun catalan(n: Int): Int {
        if (n <= 1) return 1
        var sum = 0
        for (i in 0 until n) {
            sum += catalan(i) * catalan(n - i - 1)
        }
        return sum
    }
}