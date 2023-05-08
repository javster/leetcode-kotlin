package com.javster.leetcode.medium

import com.javster.leetcode.utils.ListNode
import com.javster.leetcode.utils.printNodes

fun main() {
    val headNode = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5)
                }
            }
        }
    }
    printNodes(removeNthFromEnd(ListNode(1), 1))
    printNodes(removeNthFromEnd(headNode, 3))
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    var current = head
    val list = mutableListOf<ListNode>()
    while (current != null) {
        list.add(current)
        current = current.next
    }
    val size = list.size
    val index = size - n
    return if (index < 0) {
        head
    } else if (index == 0) {
        list[0].next
    } else {
        list[index - 1].next = list[index].next
        head
    }
}