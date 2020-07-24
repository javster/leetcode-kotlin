package com.javster.leetcode


fun main() {
    val graph1 = arrayOf(
        intArrayOf(1,2),
        intArrayOf(3),
        intArrayOf(3),
        intArrayOf()
    )

    val graph2 = arrayOf(
        intArrayOf(4,3,1),
        intArrayOf(3,2,4),
        intArrayOf(3),
        intArrayOf(4),
        intArrayOf()
    )

    AllPathsFromSourceToTarget().allPathsSourceTarget(graph2).forEach { list ->
        list.forEach { print("$it,") }
        println()
    }
}

class AllPathsFromSourceToTarget {

    private val result = ArrayList<IntArray>()

    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        traverse(graph, 0, IntArray(1) { 0 })
        return result.map { it.toList() }
    }

    private fun traverse(graph: Array<IntArray>, index: Int, path: IntArray) {
        graph[index].forEach {
            val newArray = path.copyOf(path.size + 1)
            newArray[path.size] = it
            if (it == graph.size - 1) {
                result.add(newArray)
            } else {
                traverse(graph, it, newArray)
            }
        }
    }
}