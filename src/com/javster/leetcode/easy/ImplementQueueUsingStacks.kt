package com.javster.leetcode.easy

import java.lang.IllegalStateException

class MyQueue {

    val list = mutableListOf<Int>()

    fun push(x: Int) {
        list.add(x)
    }

    fun pop(): Int {
        if (list.size == 0) {
            throw IllegalStateException()
        }
        return list.removeAt(0)
    }

    fun peek(): Int {
        if (list.size == 0) {
            throw IllegalStateException()
        }
        return list[0]
    }

    fun empty(): Boolean {
        return list.size == 0
    }

}

fun main() {
    val queue = MyQueue()
    with(queue) {
        push(1)
        push(2)
        println(peek())
        println(pop())
        println(empty())
    }
}