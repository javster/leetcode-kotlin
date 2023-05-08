package com.javster.leetcode.easy

abstract class VersionControl(private val versions: BooleanArray) {
    fun isBadVersion(version: Int): Boolean {
        if ((version - 1) < 0) return true
        return versions[version - 1]
    }

    abstract fun firstBadVersion(n: Int): Int
}

class Solution(versions: BooleanArray) : VersionControl(versions) {
    override fun firstBadVersion(n: Int): Int {
        var p = 1
        var r = n
        while (p <= r) {
            val q = p + (r - p) / 2
            val badVersion = isBadVersion(q)
            if (badVersion && !isBadVersion(q - 1)) {
                return q
            }
            if (badVersion) {
                r = q - 1
            } else {
                p = q + 1
            }
        }
        return -1
    }
}

fun main() {
    println(Solution(booleanArrayOf(false, true, true, true)).firstBadVersion(4))
    println(Solution(booleanArrayOf(false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true)).firstBadVersion(16))
    println(Solution(booleanArrayOf(true)).firstBadVersion(1))
}