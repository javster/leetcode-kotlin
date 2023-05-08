package com.javster.leetcode.sliding_window

fun findAnagrams(s: String, p: String): List<Int> {
    val listOfAnagrams = mutableListOf<Int>()

    var start = -1
    var searchString = p.toMutableList()

    var i = 0
    while (i < s.length) {
        val c = s[i]
        if (searchString.contains(c)) {
            if (start == -1) {
                start = i
            }
            searchString.remove(c)
            if (searchString.size == 0) {
                listOfAnagrams.add(start)
                start = -1
                searchString = p.toMutableList()
            }
            i++
        } else if (start > -1) {
            start = -1
            searchString = p.toMutableList()
        } else {
            i++
        }
    }
    return listOfAnagrams
}

fun main() {
    findAnagrams(s = "cbaebabacd", p = "abc").forEach {
        print("$it ")
    }
    findAnagrams(s = "abab", p = "ab").forEach {
        print("$it ")
    }
}