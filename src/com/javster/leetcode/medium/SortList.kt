package com.javster.leetcode.medium

import com.javster.leetcode.utils.ListNode
import com.javster.leetcode.utils.printNodes

fun sortList(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    val list = mutableListOf<ListNode>()
    var node = head
    while (node != null) {
        list.add(node)
        node = node.next
    }
    list.sortWith(Comparator { o1, o2 -> o1.`val` - o2.`val` })

    for (i in 1 until list.size) {
        list[i - 1].next = list[i]
    }
    list.last().next = null
    return list[0]
}

fun main() {
    val list1 = ListNode(4).apply {
        next = ListNode(3).apply {
            next = ListNode(2).apply {
                next = ListNode(1)
            }
        }
    }
    printNodes(sortList(list1))

    val list2 = ListNode(-1).apply {
        next = ListNode(5).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply {
                    next = ListNode(0)
                }
            }
        }
    }
    printNodes(sortList(list2))

    println(sortList(null))
}