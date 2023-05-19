package com.javster.leetcode.arrays.medium

fun asteroidCollision(asteroids: IntArray): IntArray {
    val forward = mutableMapOf<Int, Int>()
    val backward = mutableMapOf<Int, Int>()
    var leftmostForward = asteroids.size
    var rightmostBackward = -1
    asteroids.forEachIndexed { i, a ->
        if (a > 0) {
            forward[i] = a
            if (i < leftmostForward) {
                leftmostForward = i
            }
        }
        if (a < 0) {
            backward[i] = a
            if (i > rightmostBackward) {
                rightmostBackward = i
            }
        }
    }

    while (forward.isNotEmpty() && backward.isNotEmpty() && rightmostBackward > leftmostForward) {
        var iterator = forward.iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            val position = next.key
            val weight = Math.abs(next.value)
            val nextPosition = position + 1
            if (backward.contains(nextPosition)) {
                val oppositeWeight = Math.abs(backward[nextPosition]!!)
                if (weight > oppositeWeight) {
                    backward.remove(nextPosition)
                } else if (weight < oppositeWeight) {
                    iterator.remove()
                } else {
                    iterator.remove()
                    backward.remove(nextPosition)
                }
            }
        }

        leftmostForward = asteroids.size
        var temp = mutableMapOf<Int, Int>().apply {
            forward.forEach { (k, v) ->
                put(k, v)
            }
        }
        forward.clear()
        temp.forEach { (k, v) ->
            forward[k + 1] = v
            if (k + 1 < leftmostForward) {
                leftmostForward = k + 1
            }
        }

        iterator = backward.iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            val position = next.key
            val weight = Math.abs(next.value)
            val nextPosition = position - 1
            if (forward.contains(nextPosition)) {
                val oppositeWeight = Math.abs(forward[nextPosition]!!)
                if (weight > oppositeWeight) {
                    forward.remove(nextPosition)
                } else if (weight < oppositeWeight) {
                    iterator.remove()
                } else {
                    iterator.remove()
                    forward.remove(nextPosition)
                }
            }
        }

        rightmostBackward = -1
        temp = mutableMapOf<Int, Int>().apply {
            backward.forEach { (k, v) ->
                put(k, v)
            }
        }
        backward.clear()
        temp.forEach { (k, v) ->
            backward[k - 1] = v
            if (k - 1 > rightmostBackward) {
                rightmostBackward = k - 1
            }
        }
    }

    return (forward + backward).entries.sortedBy { it.key }.map { it.value }.toIntArray()
}

fun main() {
    asteroidCollision(intArrayOf(10,2,-5)).forEach {
        print("$it ")
    }
    println()
    asteroidCollision(intArrayOf(5,10,-5)).forEach {
        print("$it ")
    }
    println()
    asteroidCollision(intArrayOf(2,-2)).forEach {
        print("$it ")
    }
    asteroidCollision(intArrayOf(-2,-2,-1,-2)).forEach {
        print("$it ")
    }

}