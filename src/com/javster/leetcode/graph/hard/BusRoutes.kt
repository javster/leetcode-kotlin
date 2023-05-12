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
            arrayOf(
            intArrayOf(1,21,24,29,35,55,57,64,65,69,72,77,93,104,107,117,128),
            intArrayOf(3,7,8,22,29,31,37,42,49,51,61,69,75,83,91,92,98,119,120),
            intArrayOf(9,25,45,67,103,105,122,128),
            intArrayOf(0,2,10,14,16,26,35,48,52,71,85,88,100,102,107,110,114,115,117,125,126),
            intArrayOf(1,14,25,33,36,38,41,47,48,53,57,76,85,86,87,93,96,97,102,105,106,114,122),
            intArrayOf(97),
            intArrayOf(7,22,30,39,47,66,70,86,87,101,104),
            intArrayOf(3,4,6,17,18,29,34,35,37,52,65,74,75,85,96,99,107,110,112,117),
            intArrayOf(40,45,70,72,83,87,101,121),
            intArrayOf(73,110),
            intArrayOf(5,11,17,31,41,44,51,63,87,90,91,94,97,98,109,114,118,126),
            intArrayOf(22,37,54,62,67,96,99,111,118),
            intArrayOf(5,20,21,34,35,42,55,56,82),
            intArrayOf(18,24,40,43,48,51,61,76,84,91,109,119,123),
            intArrayOf(5,11,14,18,23,36,42,43,50,51,53,61,70,75,76,81,85,88,92,94,95,103,105,128),
            intArrayOf(114),
            intArrayOf(11,17,19,21,23,28,46,47,59,67,72,73,74,75,79,86,87,89,101,102,105,111,126),
            intArrayOf(0,14,21,29,45,50,64,69,74,79,81,115,125,129),
            intArrayOf(4,9,22,33,39,45,55,66,69,70,78,84,89,97,98,107,110,113,114,120),
            intArrayOf(2,22,38,62,79,89,92,96,123),
            intArrayOf(22,40,55,65,105,107,119,126),
            intArrayOf(6,11,13,31,37,38,48,63,67,74,81,93,96,101,104,105,108,121,127),
            intArrayOf(3,19,40,42,69,79),
            intArrayOf(4,19,33,41,43,60,71,78,79,90,104,110,118,127),
            intArrayOf(16,26,27,36,37,49,68,91,92,108),
            intArrayOf(12,17,41,48,55,59,66,101,103)
        ), 102, 66) == 2
    )

    val start = System.currentTimeMillis()
    println(busRoutes.numBusesToDestination(bigRoutes, 712, 465))
    println("${System.currentTimeMillis() - start}")
}