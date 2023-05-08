package com.javster.leetcode.easy

import com.javster.leetcode.utils.TreeNode
import com.javster.leetcode.utils.printInOrder
import com.javster.leetcode.utils.treeOfIntsInOrder

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }

    fun reverse(node: TreeNode) {
        val left = node.left
        val right = node.right
        node.left = right
        node.right = left
        left?.let {
            reverse(left)
        }
        right?.let {
            reverse(right)
        }
    }

    reverse(root)
    return root
}

fun main() {
    val tree = treeOfIntsInOrder(arrayOf(4, 2, 7, 1, 3, 6, 9))
    invertTree(tree)
    printInOrder(tree!!)
}