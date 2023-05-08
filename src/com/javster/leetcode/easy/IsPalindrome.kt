package com.javster.leetcode.easy

import com.javster.leetcode.utils.ListNode

fun isPalindrome(head: ListNode?): Boolean {
    var node = head
    val list = mutableListOf<ListNode>()
    while (node != null) {
        list.add(node)
        node = node.next
    }
    var p = 0
    var q = list.size - 1
    while (p < q) {
        if (list[p].`val` != list[q].`val`) {
            return false
        }
        p++
        q--
    }
    return true
}

fun main() {
    val headNode = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(2).apply {
                    next = ListNode(1)
                }
            }
        }
    }
    println(isPalindrome(headNode))
}