package com.javster.leetcode

import com.javster.leetcode.utils.ListNode
import com.javster.leetcode.utils.printNodes
import com.javster.leetcode.utils.sortedLinkedList

fun middleNode(head: ListNode?): ListNode? {
    val array = mutableListOf<ListNode>()
    var node = head
    while (node != null) {
        array.add(node)
        node = node.next
    }
    val middle = array.size / 2
    return array[middle]
}

fun main() {
    val l = sortedLinkedList(6)
    val l1 = sortedLinkedList(5)
    printNodes(middleNode(l1))
}