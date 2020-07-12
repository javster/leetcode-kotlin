package com.javster.leetcode

fun main() {
    val stack = MinStack().apply {
        push(-2)
        push(0)
        push(-3)

        println(getMin())
        pop()
        println(top())
        println(getMin())
    }

}

class MinStack() {
    private var stackList = ArrayList<Int>()
    private var minimums = ArrayList<Int>()

    fun push(x: Int) {
        stackList.add(x)
        minimums.apply {
            add(x)
            this.sort()
        }
    }

    fun pop() {
        if (stackList.isNotEmpty()) {
            minimums.remove(stackList[stackList.size - 1])
            stackList.removeAt(stackList.size - 1)
        }
    }

    fun top() = stackList[stackList.size - 1]

    fun getMin() = minimums[0]
}