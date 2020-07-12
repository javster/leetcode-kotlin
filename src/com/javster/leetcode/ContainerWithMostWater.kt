package com.javster.leetcode

fun main() {

    val time = System.currentTimeMillis()
    println(maxArea2(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    println(maxArea2(intArrayOf(1, 8, 6, 2, 7)))
    println(maxArea2(intArrayOf(1, 2)))
    println(
        maxArea1(
            intArrayOf(
                9384,
                887,
                2778,
                6916,
                7794,
                8336,
                5387,
                493,
                6650,
                1422,
                2363,
                28,
                8691,
                60,
                7764,
                3927,
                541,
                3427,
                9173,
                5737,
                5212,
                5369,
                2568,
                6430,
                5783,
                1531,
                2863,
                5124,
                4068,
                3136,
                3930,
                9803,
                4023,
                3059,
                3070,
                8168,
                1394,
                8457,
                5012,
                8043,
                6230,
                7374,
                4422,
                4920,
                3785,
                8538,
                5199,
                4325,
                8316,
                4371,
                6414,
                3527,
                6092,
                8981,
                9957,
                1874,
                6863,
                9171,
                6997,
                7282,
                2306,
                926,
                7085,
                6328,
                337,
                6506,
                847,
                1730,
                1314,
                5858,
                6125,
                3896,
                9583,
                546,
                8815,
                3368,
                5435,
                365,
                4044,
                3751,
                1088,
                6809,
                7277,
                7179,
                5789,
                3585,
                5404,
                2652,
                2755,
                2400,
                9933,
                5061,
                9677
            )
        )
    )

    println("time spent ${System.currentTimeMillis() - time}")
}

fun maxArea1(height: IntArray): Int {
    if (height.isEmpty()) return 0
    if (height.size == 1) return height[0]

    val area = Array(height.size) { IntArray(height.size) }
    for (i in height.indices) {
        area[i][i] = height[i]
    }

    var max = 0
    for (a in 1 until area.size) {
        for (i in 0 until area.size - a) {
            val j = i + a
            val edgeVolume = Math.min(area[i][i], area[j][j]) * (j - i)
            val innerMax = if (j - 1 - i > 0) {
                Math.max(area[i][j - 1], area[i + 1][j])
            } else {
                0
            }
            area[i][j] = Math.max(innerMax, edgeVolume)
            max = Math.max(max, area[i][j])
        }
    }
    return max
}

fun maxArea2(height: IntArray): Int {
    if (height.isEmpty() || height.size == 1) return 0
    var max = 0
    var left = 0
    var right = height.size - 1
    while (left < right) {
        val area = Math.min(height[left], height[right]) * (right - left)
        max = Math.max(max, area)
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return max
}
