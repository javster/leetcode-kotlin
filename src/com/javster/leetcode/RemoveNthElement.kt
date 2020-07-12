package com.javster.leetcode

fun main() {
    val headNode = ListNode1(1).apply {
        next = ListNode1(2).apply {
            next = ListNode1(3).apply {
                next = ListNode1(4).apply {
                    next = ListNode1(5)
                }
            }
        }
    }
    val res = removeNthFromEnd(ListNode1(1), 1)
    printAll(res)
}

class ListNode1(var `val`: Int) {
    var next: ListNode1? = null
}

fun removeNthFromEnd(head: ListNode1?, n: Int): ListNode1? {
    if (head == null) return null
    var size = 0
    var current = head
    val map = HashMap<Int, ListNode1?>()
    while (current != null) {
        map[size++] = current
        current = current.next
    }
    map[size] = null
    if (size < n) {
        return head
    }
    if (n == 0 && size - 2 >= 0) {
        map[size - 2]!!.next = null
    } else
        if (size - n - 1 >= 0) {
            map[size - n - 1]!!.next = map[size - n + 1]
        } else {
            return head.next
        }
    return head
}

fun printAll(head: ListNode1?) {
    var current = head
    while (current != null) {
        println("${current.`val`}")
        current = current.next
    }
}