package com.javster.leetcode

fun main() {
    println(UglyNumberII().nthUglyNumber(2))
}

class UglyNumberII {
    fun nthUglyNumber(n: Int): Int {
        if (n <= 1) {
            return 1
        }
        val list = ArrayList<Int>().apply { add(1) }
        var k = 0
        var l = 0
        var m = 0
        repeat(n - 1) {
            var l1 = list[k] * 2
            var l2 = list[l] * 3
            var l3 = list[m] * 5
            val next = Math.min(Math.min(l1, l2), l3)
            list.add(next)
            if (next == l1) {
                k++
            }
            if (next == l2) {
                l++
            }
            if (next == l3) {
                m++
            }
        }
        return list.last()
    }
}