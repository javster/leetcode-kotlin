package com.javster.leetcode

import com.javster.leetcode.utils.DoublyLinkedList

fun main() {
    val node1 = DoublyLinkedList(1)
    val node2 = DoublyLinkedList(2)
    val node3 = DoublyLinkedList(3)
    val node4 = DoublyLinkedList(4)
    val node5 = DoublyLinkedList(5)
    val node6 = DoublyLinkedList(6)
    val node7 = DoublyLinkedList(7)
    val node8 = DoublyLinkedList(8)
    val node9 = DoublyLinkedList(9)
    val node10 = DoublyLinkedList(10)
    val node11 = DoublyLinkedList(11)
    val node12 = DoublyLinkedList(12)

    node1.next = node2

    node2.next = node3
    node2.prev = node1

    node3.next = node4
    node3.prev = node2
    node3.child = node7

    node4.next = node5
    node4.prev = node3

    node5.next = node6
    node5.prev = node4

    node7.next = node8

    node8.next = node9
    node8.prev = node7
    node8.child = node11

    node9.next = node10
    node9.prev = node8

    node10.prev = node9

    node11.next = node12

    node12.prev = node11

    val new = FlattenAMultilevelDoublyLinkedList().flatten(node1)
    new?.let {
        var c: DoublyLinkedList? = it
        do {
            print("${c!!.`val`}, ")
            c = c!!.next
        } while (c != null)
    }
}

class FlattenAMultilevelDoublyLinkedList {
    fun flatten(root: DoublyLinkedList?): DoublyLinkedList? {
        if (root != null) {
            traverse(root)
        }
        return root
    }

    private fun traverse(node: DoublyLinkedList): DoublyLinkedList {
        var current = node
        do {
            val next = current.next
            current.child?.let { child ->
                current.next = child
                child.prev = current

                current.child = null

                val newLast = traverse(child)
                newLast.next = next

                if (next != null) {
                    next.prev = newLast
                } else {
                    return newLast
                }
            }
            if (next == null) return current
            current = next
        } while (next != null)

        return current
    }
}