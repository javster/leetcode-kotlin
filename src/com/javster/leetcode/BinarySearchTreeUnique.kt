package com.javster.leetcode

fun main() {
    println("${BinarySearchTreeUnique().numTrees(6)}")
}

class BinarySearchTreeUnique {
    fun numTrees(n: Int): Int {
        return g(n)
    }

    // Catalan numbers algorithm
    fun f(i: Int, n: Int): Int {
        return g(i - 1) + g(n - i)
    }

    fun g(n: Int): Int {
        if (n <= 2) {
            return n
        }

        var sum = 0

        for (i in 1..n) {
            sum += f(i, n)
        }

        return sum
    }
}