package com.javster.leetcode

fun isSubsequence(s: String, t: String): Boolean {
    var sIndex = 0
    var tIndex = 0
    while (tIndex < t.length && sIndex < s.length) {
        if (s[sIndex] == t[tIndex]) {
            sIndex++
        }
        tIndex++
    }

    return sIndex == s.length
}

fun main() {
    println(isSubsequence("abc", "ahbgdc"))
    println(isSubsequence("axc", "ahbgdc"))
    println(isSubsequence("a", "ahbgdc"))
    println(isSubsequence("abc", "a"))
    println(isSubsequence("", ""))
}