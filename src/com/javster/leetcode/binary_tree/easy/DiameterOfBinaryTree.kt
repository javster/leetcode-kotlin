package com.javster.leetcode.binary_tree.easy

import com.javster.leetcode.utils.TreeNode

fun main() {
    /* creating a binary tree and entering the nodes */
    val root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    root.left!!.left = TreeNode(4)
    root.left!!.right = TreeNode(5)
    println(
        "The diameter of given binary tree is : "
                + TreeSolution().diameterOfBinaryTree(root))
}

class TreeSolution {
    var max = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        height(root)
        return 0.coerceAtLeast(max - 1)
    }

    private fun height(node: TreeNode?): Int {
        if (node == null) return 0
        if (node.left == null && node.right == null) return 1

        val leftHeight = height(node.left)
        val rightHeight = height(node.right)

        max = max.coerceAtLeast(1 + leftHeight + rightHeight)

        return 1 + leftHeight.coerceAtLeast(rightHeight)
    }
}