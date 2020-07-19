package com.javster.leetcode

import java.util.*
import kotlin.Comparator
import kotlin.collections.HashMap


fun main() {
    TopKFrequentElements().topKFrequent(intArrayOf(1, 2), 2).forEach {
        print(it)
    }
}

class TopKFrequentElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Element>()
        val sorted = ArrayList<Element>()
        nums.forEach {
            var element = map[it]
            if (element   == null) {
                element = Element(it, 1)
                map[it] = element
                sorted.add(element)
            } else {
                sorted.remove(element)
                element.amount++
                sorted.add(element)
            }
        }
        val list = mutableListOf<Int>()
        sorted.sort()
        sorted.reversed().forEachIndexed { index, element ->
            if (index >= k) return@forEachIndexed
            list.add(element.value)
        }
        return list.toIntArray()
    }

    data class Element(val value: Int, var amount: Int) : Comparable<Element> {
        override fun compareTo(other: Element): Int {
            return when {
                amount > other.amount -> {
                    1
                }
                amount < other.amount -> {
                    -1
                }
                else -> {
                    0
                }
            }
        }
    }
}