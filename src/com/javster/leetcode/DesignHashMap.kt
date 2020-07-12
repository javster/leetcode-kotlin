package com.javster.leetcode

import java.util.*

fun main() {
    val hashMap = MyHashMap()
    hashMap.put(1, 1)
    hashMap.put(2, 2)

    println(hashMap.get(1)) // returns 1

    println(hashMap.get(3)) // returns -1 (not found)
    hashMap.put(2, 1) // update the existing value
    println(hashMap.get(2)) // returns 1
    hashMap.remove(2) // remove the mapping for 2
    println(hashMap.get(2)) // returns -1 (not found)
}

class MyHashMap {
    /** Initialize your data structure here. */
    val capacity = 10000
    private val array = Array<LinkedList<Pair<Int, Int>>>( capacity ) { LinkedList() }

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        val index = getIndex(key)
        val chain = array[index]
        if (chain.isNotEmpty()) {
            remove(key)
        }
            chain.add(Pair(key, value))
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        val chain = array[getIndex(key)]
        for (el in chain) {
            if (el.first == key) {
                return el.second
            }
        }
        return -1
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        val chain = array[getIndex(key)]
        if (chain.isEmpty()) return
        var iterator = chain.iterator()
        while (iterator.hasNext()) {
            if (iterator.next().first == key) {
                iterator.remove()
                return
            }
        }
    }

    private fun getIndex(key: Int) = Integer.hashCode(key) % 1000
}
