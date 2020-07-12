package com.javster.leetcode

import java.lang.StringBuilder

fun main() {
    println(StringShifts().stringShift("abc", arrayOf(intArrayOf(0,1), intArrayOf(1,2))))
}

class StringShifts {
    fun stringShift(s: String, shift: Array<IntArray>): String {
        var sb = StringBuilder(s)
        for (i in shift.indices) {
            val toShift = shift[i][1] - 1
            if (shift[i][0] == 0) {
                for (j in 0..toShift) {
                    val extra = sb[0]
                    sb = StringBuilder(sb.subSequence(1, s.length))
                    sb.append(extra)
                }
            } else {
                for (j in 0..toShift) {
                    val extra = sb[s.length - 1]
                    sb = StringBuilder(sb.subSequence(0, s.length - 1))
                    sb.insert(0, extra)
                }
            }
        }
        return sb.toString()
    }
}