package com.javster.leetcode.tree.easy

import com.javster.leetcode.utils.TreeNode
import com.javster.leetcode.utils.treeOfIntsInOrder

fun isBalanced(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }

    var isBalanced = true

    fun height(node: TreeNode): Int {
        if (node.left == null && node.right == null) {
            return 1
        }
        val leftHeight = if (node.left != null) {
            height(node.left!!)
        } else {
            0
        }

        val rightHeight = if (node.right != null) {
            height(node.right!!)
        } else {
            0
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced = false
        }

        return Math.max(leftHeight, rightHeight) + 1
    }

    height(root)

    return isBalanced
}

fun main() {
    println(isBalanced(treeOfIntsInOrder(arrayOf(3,9,20,null,null,15,7))))
    println(isBalanced(treeOfIntsInOrder(arrayOf(1,2,2,3,3,null,null,4,4,null,null))))
}