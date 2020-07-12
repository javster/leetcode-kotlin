package com.javster.leetcode

fun main() {
    val head = ListNode(1)
    var currentNode = head
    for (i in 2..6) {
        val newNode = ListNode(i)
        currentNode.next = newNode
        currentNode = newNode
    }
    currentNode.next = null

    val sol = MiddleNode()

    println(sol.middleNode(head)?.`val`)
}



class MiddleNode {
    fun middleNode(head: ListNode?): ListNode? {
        var currentNode = head
        var counter = 0
        while (currentNode != null) {
            counter++
            currentNode = currentNode.next
        }
        currentNode = head
        for (i in 0 until counter / 2) currentNode = currentNode?.next
        return currentNode
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}