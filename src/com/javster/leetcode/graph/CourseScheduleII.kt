package com.javster.leetcode.graph

fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
    if (numCourses == 0) {
        return IntArray(0)
    }
    val map = mutableMapOf<Int, MutableSet<Int>>()

    for (i in 1 until numCourses) {
        map[i] = mutableSetOf(i - 1)
    }

    prerequisites.forEach {
        if (it.size == 2) {
            val k = it[0]
            val v = it[1]
            map[k]?.add(v)
        }
    }

    val result = mutableSetOf<Int>()

    fun dfs(i: Int) {
        if (result.contains(i)) {
            return
        }
        if (!map.contains(i)) {
            result.add(i)
            return
        }
        map[i]?.forEach {
            dfs(it)
        }
        result.add(i)
    }

    dfs(numCourses - 1)

    return result.toIntArray()
}

fun main() {
    findOrder(
        4,
        arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(3, 1),
            intArrayOf(3, 2)
        )
    ).forEach {
        print("$it ")
    }

    println()

    findOrder(
        2, arrayOf(
            intArrayOf(1, 0)
        )
    ).forEach {
        print("$it ")
    }

    println()

    findOrder(
        1, arrayOf(
            intArrayOf()
        )
    ).forEach {
        print("$it ")
    }

    println()

    findOrder(
        2, arrayOf(
            intArrayOf()
        )
    ).forEach {
        print("$it ")
    }


}