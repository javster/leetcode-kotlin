package com.javster.leetcode

import com.javster.leetcode.utils.ListNode

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val list = mutableListOf<ListNode>()
    var nextNode: ListNode? = list1
    while (nextNode != null) {
        list.add(nextNode!!)
        nextNode = nextNode.next
    }
    nextNode = list2
    while (nextNode != null) {
        list.add(nextNode!!)
        nextNode = nextNode.next
    }

    if (list.isEmpty()) {
        return null
    }

    list.sortBy { it.`val` }

    list.forEachIndexed { index, listNode ->
        if (index == list.size - 1) {
            listNode.next = null
        } else {
            listNode.next = list[index + 1]
        }
    }

    return list[0]
}

fun main() {
    val list1 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(4)
        }
    }

    val list2 = ListNode(1).apply {
        next = ListNode(3).apply {
            next = ListNode(4)
        }
    }

    var node = mergeTwoLists(ListNode(2), ListNode(1))
    while (node != null) {
        println(node.`val`)
        node = node.next
    }
}