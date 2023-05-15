package com.javster.leetcode.graph.hard


class BusRoutes {
    data class Vertex(
        var transfers: Int = Int.MAX_VALUE,
        var stop: Int,
        var route: Int
    )

    data class Edge(val u: Vertex, val v: Vertex, val isTransfer: Boolean = false)

    private fun relax(e: Edge) {
        val u = e.u
        val v = e.v
        if (u.transfers < Int.MAX_VALUE && v.transfers > u.transfers + if (e.isTransfer) 1 else 0) {
            v.transfers = u.transfers + if (e.isTransfer) 1 else 0
        }
    }

    fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
        if (routes.isEmpty()) {
            return -1
        }

        if (routes.size == 1 && routes[0].isEmpty()) {
            return -1
        }

        if (source == target) {
            return 0
        }

        val edges = mutableListOf<Edge>()
        val verticesMap = mutableMapOf<Int, MutableSet<Vertex>>()
        var vertexCount = 0

        routes.forEachIndexed { route, stops ->
            val routeLast = stops.lastIndex

            lateinit var firstVertex: Vertex
            var previousVertex: Vertex? = null

            vertexCount += stops.size

            var hasSource = false
            var hasTarget = false

            stops.forEachIndexed { i, stop ->
                val vertex = Vertex(stop = stop, route = route)
                if (stop == source) {
                    hasSource = true
                }
                if (stop == target) {
                    hasTarget = true
                }
                if (verticesMap.contains(stop)) {
                    verticesMap[stop]!!.add(vertex)
                } else {
                    verticesMap[stop] = mutableSetOf(vertex)
                }

                if (i == 0) firstVertex = vertex

                previousVertex?.let {
                    edges.add(Edge(it, vertex))
                }
                previousVertex = vertex

                if (i == routeLast) {
                    edges.add(Edge(vertex, firstVertex))
                }
            }

            if (hasSource && hasTarget) {
                return 1
            }
        }

        /**
         *
         */
        val maxBy = verticesMap.entries.maxBy { it.value.size }
        if (maxBy!!.value.size == 1) {
            return -1
        }

        verticesMap.entries.forEach {
            if (it.value.size > 1) {
                val list = it.value.toList()
                list.forEachIndexed { i, u ->
                    for (j in i + 1 until list.size) {
                        val v = list[j]
                        edges.add(Edge(u, v, true))
                        edges.add(Edge(v, u, true))
                    }
                }
            }
        }

        verticesMap[source]!!.forEach {
            it.transfers = 1
        }

        for (i in 1 until vertexCount) {
            for (edge in edges) {
                relax(edge)
            }
        }

        val min = verticesMap[target]!!.minBy { it.transfers }!!.transfers
        return if (min == Int.MAX_VALUE) -1 else min
    }
}

fun main() {
    val busRoutes = BusRoutes()
    require(
        busRoutes.numBusesToDestination(
            arrayOf(
                intArrayOf(1, 2, 7),
                intArrayOf(3, 6, 7)
            ), 1, 6
        ) == 2
    )

    require(
        busRoutes.numBusesToDestination(
            arrayOf(
                intArrayOf(7, 12),
                intArrayOf(4, 5, 15),
                intArrayOf(6),
                intArrayOf(15, 19),
                intArrayOf(9, 12, 13)
            ), 15, 12
        ) == -1
    )


    require(
        busRoutes.numBusesToDestination(
            arrayOf(
                intArrayOf(1, 2, 3, 4)
            ), 2, 1
        ) == 1
    )

    require(
        busRoutes.numBusesToDestination(
            arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(1, 6, 7, 8),
                intArrayOf(1, 10, 11, 12),
                intArrayOf(1, 13, 14, 15)
            ), 1, 15
        ) == 1
    )

    require(
        busRoutes.numBusesToDestination(
            arrayOf(intArrayOf()), 1, 15
        ) == -1
    )

    require(
        busRoutes.numBusesToDestination(
            arrayOf(
                intArrayOf(1),
                intArrayOf(1, 2),
                intArrayOf(2, 3)
            ), 1, 3
        ) == 2
    )

    require(
        busRoutes.numBusesToDestination(
            arrayOf(
                intArrayOf(1)
            ), 1, 1
        ) == 0
    )

    require(
        busRoutes.numBusesToDestination(
            arrayOf(
                intArrayOf(4, 8, 7, 6, 5, 1, 3),
                intArrayOf(2, 3, 4),
                intArrayOf(2, 5, 10)
            ), 1, 10
        ) == 2
    )

    require(
        busRoutes.numBusesToDestination(
            testCase1, 102, 66) == 2
    )
//
//    println(busRoutes.numBusesToDestination(bigRoutes, 712, 465))

    val time = System.currentTimeMillis()
    require(busRoutes.numBusesToDestination(getMonotonic(300, 300), 0, 90000) == -1)
    println("${System.currentTimeMillis() - time}")
}