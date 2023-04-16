package com.javster.leetcode

import com.javster.leetcode.utils.ListNode
import com.javster.leetcode.utils.printNodes

fun main() {
    val headNode = ListNode(1)
        .apply {
        next = ListNode(2)
            .apply {
            next = ListNode(3).apply {
                next = ListNode(4)
            }
        }
    }
    val res = swapPairs(headNode)
    printNodes(res)
}

fun swapPairs(head: ListNode?): ListNode? {
    var head = head
    var current = head
    var previous: ListNode? = null
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