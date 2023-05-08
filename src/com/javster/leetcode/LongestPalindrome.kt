package com.javster.leetcode

fun longestPalindrome(s: String): Int {
    val counts = mutableMapOf<Char, Int>()
    s.forEach {
        counts[it] = (counts[it] ?: 0) + 1
    }
    var evens = 0
    var odds = 0
    counts.forEach {
        if (it.value % 2 == 0) {
            evens += it.value
        } else {
            evens += ((it.value) / 2) * 2
            if (it.value % 2 == 1) {
                odds = 1
            }
        }
    }
    return evens + odds
}

fun main() {
    println(longestPalindrome("abccccdd"))
    println(longestPalindrome("a"))
    println(longestPalindrome("a"))
    println(longestPalindrome("ccc"))
    println(longestPalindrome("aabbbbcdef"))
}