package com.javster.leetcode.intervals.medium

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {

    class Interval(val start: Int, val end: Int) {
        fun intersects(other: Interval): Boolean {
            if (other.start in start..end || start in other.start..other.end) {
                return true
            }
            if (other.end in start..end || end in other.start..other.end) {
                return true
            }
            return false
        }
    }

    val result = mutableListOf<IntArray>()
    val ns = newInterval[0]
    val ne = newInterval[1]
    val new = Interval(ns, ne)
    val toMerge = mutableListOf<Int>()
    var pos = 0

    for (i in intervals.indices) {
        val s = intervals[i][0]
        val e = intervals[i][1]
        val interval = Interval(s, e)
        if (interval.intersects(new)) {
            toMerge.add(i)
        }
        if (ns > e) {
            pos = i + 1
        }
    }
    if (toMerge.isEmpty()) {
        intervals.forEachIndexed { i, e ->
            if (i == pos) {
                result.add(newInterval)
            }
            result.add(e)
        }
        if (pos == intervals.size) {
            result.add(newInterval)
        }
    } else {
        val start = intervals[toMerge[0]][0]
        val end = intervals[toMerge.last()][1]

        val finalStart = if (ns <= start) {
            ns
        } else {
            start
        }
        val finalEnd = if (ne >= end) {
            ne
        } else {
            end
        }

        for (i in 0 until toMerge.first()) {
            result.add(intervals[i])
        }

        result.add(intArrayOf(finalStart, finalEnd))

        for (i in toMerge.last() + 1 until intervals.size) {
            result.add(intervals[i])
        }

    }

    return result.toTypedArray()
}

fun main() {
    val r = insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5))
    r.forEach {
        print("[${it[0]}, ${it[1]}] ")
    }

    println()

    insert(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 5),
            intArrayOf(6, 7),
            intArrayOf(8, 10),
            intArrayOf(12, 16)
        ), intArrayOf(4, 8)
    ).forEach {
        print("[${it[0]}, ${it[1]}] ")
    }

    println()

    insert(
        arrayOf(
            intArrayOf(2, 2),
            intArrayOf(3, 5),
            intArrayOf(6, 7),
            intArrayOf(8, 10),
            intArrayOf(12, 16)
        ), intArrayOf(2, 18)
    ).forEach {
        print("[${it[0]}, ${it[1]}] ")
    }
}