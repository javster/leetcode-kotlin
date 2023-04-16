package com.javster.leetcode.utils

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun printNodes(head: ListNode?) {
    var node = head
    while (node != null) {
        println(node.`val`)
        node = node.next
    }
}

fun sortedLinkedList(length: Int): ListNode?{
    var previous: ListNode? = null
    var head: ListNode? = null
    for (i in 0 until length) {
        val node = ListNode(i + 1)
        if (head == null) {
            head = node
        }
        if (previous != null) {
            previous.next = node
        }
        previous = node
    }
    return head
}