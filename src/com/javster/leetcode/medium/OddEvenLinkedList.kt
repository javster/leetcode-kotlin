package com.javster.leetcode.medium

import com.javster.leetcode.utils.ListNode
import com.javster.leetcode.utils.printNodes

fun oddEvenList(head: ListNode?): ListNode? {
    if (head?.next == null) {
        return head
    }
    var i = 2
    var node = head.next
    var lastOdd = head!!
    var lastEven = node!!
    while (node != null) {
        if (i % 2 == 1) {
            val tmp = lastOdd.next
            lastOdd.next = node
            lastEven.next = node.next
            node.next = tmp
            lastOdd = node
            node = lastEven
        } else {
            lastEven = node
        }
        i++
        node = node.next
    }
    return head
}

fun main() {
    val head = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(5).apply {
                        next = ListNode(6).apply {
                            next = ListNode(7).apply {
                                next = ListNode(8).apply {
                                    next = ListNode(9)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    printNodes(oddEvenList(head))
    printNodes(oddEvenList(ListNode(1)))
    printNodes(oddEvenList(ListNode(1).apply { next = ListNode(2) }))
    printNodes(oddEvenList(ListNode(1).apply { next = ListNode(2).apply { next = ListNode(3) } }))

}