package com.javster.leetcode.utils

data class Vertex(var d: Int = Int.MAX_VALUE, var p: Vertex? = null)

data class Edge(val u: Vertex, val v: Vertex)

fun relax(e: Edge, w: Int) {
    val u = e.u
    val v = e.v
    if (v.d > u.d + w) {
        v.d = u.d + w
        v.p = u
    }
}