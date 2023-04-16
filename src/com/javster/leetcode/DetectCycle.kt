package com.javster.leetcode

import com.javster.leetcode.utils.ListNode

fun detectCycle(head: ListNode?): ListNode? {
    val map = mutableMapOf<ListNode, Int>()
    var node = head
    var counter = 0
    while (node != null) {
        val next = node.next
        if (next == node) {
            return node
        }
        val nextIndex = map[next]
        if ((nextIndex ?: counter) < counter) {
            return next
        }
        map[node] = counter
        node = next
        counter++
    }

    return null
}

fun main() {
    val node1 = ListNode(3)
    val node2 = ListNode(2)
    val node3 = ListNode(0)
    val node4 = ListNode(-4)
    node1.next = node2
    node2.next = node3
    node3.next = node4
    node4.next = node2
    println(detectCycle(node1)?.`val`)
}