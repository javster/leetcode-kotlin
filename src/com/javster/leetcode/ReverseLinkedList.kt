package com.javster.leetcode

import com.javster.leetcode.utils.ListNode
import com.javster.leetcode.utils.printNodes
import com.javster.leetcode.utils.sortedLinkedList

fun reverseList(head: ListNode?): ListNode? {
    var previous: ListNode? = null
    var node = head
    while (node != null) {
        val next = node.next
        node.next = previous
        previous = node
        node = next
    }
    return previous
}

fun main() {
    printNodes(reverseList(sortedLinkedList(5)))
}