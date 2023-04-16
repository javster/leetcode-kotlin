package com.javster.leetcode

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
    val res = removeNthFromEnd(ListNode(1), 1)
    printNodes(res)
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null
    var size = 0
    var current = head
    val map = HashMap<Int, ListNode?>()
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