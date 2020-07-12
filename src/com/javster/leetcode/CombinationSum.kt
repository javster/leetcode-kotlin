package com.javster.leetcode

fun main() {
    val answer = combinationSum(intArrayOf(7, 3, 2), 18)
    println("")
}

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    var answers = ArrayList<ArrayList<Int>>()
    val backmap = HashMap<Int, ArrayList<ArrayList<Int>>>() //sum, pos
    val initialBacks = ArrayList<ArrayList<Int>>()
    //fill sums
    candidates.sort()
    for (i in candidates.indices) {
        var reminder = target
        var repeats = 1
        while (reminder > 0) {
            reminder -= candidates[i]
            val repeatedArray = ArrayList<Int>().apply {
                repeat(repeats) {
                    add(candidates[i])
                }
            }

            initialBacks.add(repeatedArray)

            if (backmap.contains(candidates[i] * repeats)) {
                backmap[candidates[i] * repeats]!!.add(repeatedArray)
            } else {
                backmap[candidates[i] * repeats] = ArrayList<ArrayList<Int>>().apply {
                    add(repeatedArray)
                }
            }

            if (reminder == 0) {
                answers.add(repeatedArray)
            }

            repeats++
        }
    }

    initialBacks.forEach { prefixArray ->
        var sum = prefixArray.sum()
        val supposedArray = ArrayList<Int>()
        supposedArray.addAll(prefixArray)
        while (sum < target) {

        }

        val appropriateEnds = backmap[target - sum]
        appropriateEnds?.forEach { suffixArray ->
            answers.add(ArrayList<Int>(suffixArray).apply {
                addAll(prefixArray)
            })
        }
    }

    return answers.distinct()
}

//fun recursiveSearch(array: ArrayList<Int>, backmap: HashMap<Int, ArrayList<ArrayList<Int>>>, sum: Int, target: Int): ArrayList<ArrayList<Int>>? {
//    val appropriateEnds = backmap[target - sum]
//    if (appropriateEnds != null && appropriateEnds.isNotEmpty()) {
//
//    } else {
//        return emptyList<ArrayList<Int>>()
//    }
//}