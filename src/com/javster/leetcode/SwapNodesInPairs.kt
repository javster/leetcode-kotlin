package com.javster.leetcode

fun main() {
    val headNode = ListNode2(1)
        .apply {
        next = ListNode2(2)
            .apply {
            next = ListNode2(3).apply {
                next = ListNode2(4)
            }
        }
    }
    val res = swapPairs(headNode)
    printAll(res)
}

fun swapPairs(head: ListNode2?): ListNode2? {
    var head = head
    var current = head
    var previous: ListNode2? = null
    while (current?.next != null) {
        var temp = current.next!!.next
        current.next!!.next = current
        if (previous == null) {
            head = current.next
        } else {
            previous.next = current.next
        }
        previous = current
        current.next = temp
        current = temp
    }
    return head
}

class ListNode2(var `val`: Int) {
    var next: ListNode2? = null
}

fun printAll(head: ListNode2?) {
    var current = head
    while (current != null) {
        println("${current.`val`}")
        current = current.next
    }
}