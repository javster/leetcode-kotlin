package com.javster.leetcode

import kotlin.collections.HashMap

fun main() {
    val s1 = "abcabcbb"
    val s2 = "bbbbb"
    val s3 = "pwwkew"
    val s4 = "aab"
    val s5 = "abba"
    require(lengthOfLongestSubstring(s1) == 3)
    require(lengthOfLongestSubstring(s2) == 1)
    require(lengthOfLongestSubstring(s3) == 3)
    require(lengthOfLongestSubstring(s4) == 2)
    require(lengthOfLongestSubstring(s5) == 2)
}

fun lengthOfLongestSubstring(s: String): Int {
    if (s.isEmpty()) return 0
    var map: MutableMap<Char, Int> = HashMap<Char, Int>()
    var longest = 0
    var startIndex = 0
    var i = 0
    while (i < s.length) {
        if (map.contains(s[i])) {
            longest = Math.max(longest, i - startIndex)
            startIndex = map[s[i]]!! + 1
            map = map.filter {
                it.value > startIndex - 1
            }.toMutableMap()
            map[s[i]] = i
        } else {
            map[s[i]] = i
        }
        i++
    }
    longest = Math.max(longest, s.length - startIndex)
    return longest
}