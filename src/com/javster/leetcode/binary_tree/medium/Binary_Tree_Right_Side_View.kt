package com.javster.leetcode.binary_tree.medium

import com.javster.leetcode.utils.TreeNode
import com.javster.leetcode.utils.treeOfIntsInOrder

fun rightSideView(root: TreeNode?): List<Int> {
    val righteous = mutableListOf<Int>()

    if (root == null) {
        return righteous
    }

    fun inOrderTraversal(node: TreeNode, level: Int) {
        if (righteous.size == level) {
            righteous.add(node.`val`)
        } else {
            righteous[level] = node.`val`
        }
        node.left?.let {
            inOrderTraversal(it, level + 1)
        }
        node.right?.let {
            inOrderTraversal(it, level + 1)
        }
    }

    inOrderTraversal(root, 0)

    return righteous
}

fun main() {
    println(rightSideView(treeOfIntsInOrder(arrayOf(1, 2, 3, null, 5, null, 4))))
    println(rightSideView(treeOfIntsInOrder(arrayOf(1, null, 3))))
    println(rightSideView(treeOfIntsInOrder(arrayOf(1, 2, null))))
}