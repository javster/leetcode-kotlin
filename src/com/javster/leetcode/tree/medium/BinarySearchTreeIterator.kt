package com.javster.leetcode.tree.medium

import com.javster.leetcode.utils.TreeNode

class BSTIterator(root: TreeNode?) {
    private val start = BSTItem(node = null, next = null)

    data class BSTItem(val node: TreeNode?, var next: BSTItem?)

    private var node = start

    init {
        fun traverse(node: TreeNode?, previousItem: BSTItem): BSTItem? {
            if (node == null) {
                return null
            }

            var lastItem = previousItem
            node.left?.let {
                lastItem = traverse(it, lastItem)!!
            }

            val parent = BSTItem(node, null)
            lastItem.next = parent
            lastItem = parent

            node.right?.let {
                lastItem = traverse(it, lastItem)!!
            }
            return lastItem
        }

        traverse(root, start)
    }

    fun next(): Int {
        val next = node.next!!
        node = next
        return next.node?.`val` ?: -1
    }

    fun hasNext(): Boolean {
        return node.next != null
    }
}

fun main() {
//    val root = TreeNode(7).apply {
//        left = TreeNode(3)
//        right = TreeNode(15).apply {
//            left = TreeNode(9)
//            right = TreeNode(20)
//        }
//    }
//    val i = BSTIterator(root)
//    println(i.next())
//    println(i.next())
//    println(i.hasNext())
//    println(i.next())
//    println(i.hasNext())
//    println(i.next())
//    println(i.hasNext())
//    println(i.next())
//    println(i.hasNext())


    val root = TreeNode(3).apply {
        left = TreeNode(1).apply {
            right = TreeNode(2)
        }
        right = TreeNode(4)
    }
    val i = BSTIterator(root)
    println(i.hasNext())
    println(i.next())
    println(i.hasNext())
    println(i.next())
    println(i.hasNext())
    println(i.next())
    println(i.hasNext())
    println(i.next())
    println(i.hasNext())
}
