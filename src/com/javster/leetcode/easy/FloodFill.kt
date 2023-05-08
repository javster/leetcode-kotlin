package com.javster.leetcode.easy

fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    if (image[sr][sc] == color) {
        return image
    }
    val orig = image[sr][sc]
    image[sr][sc] = color
    if (sr > 0 && image[sr - 1][sc] == orig) {
        floodFill(image, sr - 1, sc, color)
    }
    if (sc < image[sr].size - 1 && image[sr][sc + 1] == orig) {
        floodFill(image, sr, sc + 1, color)
    }
    if (sr < image.size - 1 && image[sr + 1][sc] == orig) {
        floodFill(image, sr + 1, sc, color)
    }
    if (sc > 0 && image[sr][sc - 1] == orig) {
        floodFill(image, sr, sc - 1, color)
    }
    return image
}

fun main() {
//    val r = floodFill(arrayOf(intArrayOf(1,1,1),intArrayOf(1,1,0),intArrayOf(1,0,1)), 1, 1, 2)
    val r = floodFill(arrayOf(intArrayOf(0,0,0),intArrayOf(0,0,0)), 0, 0, 0)
    r.forEach {
        it.forEach {
            print("$it ")
        }
        println()
    }
}