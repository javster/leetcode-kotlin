package com.javster.leetcode.binary_tree.medium

import com.javster.leetcode.utils.TreeNode

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val levels = mutableListOf<MutableList<Int>>()
    fun traverse(root: TreeNode, level: Int) {
        if (levels.size <= level) {
            levels.add(mutableListOf())
        }

        if (root.left != null) {
            traverse(root.left!!, level + 1)
        }
        if (root.right != null) {
            traverse(root.right!!, level + 1)
        }

        levels[level].add(root.`val`)
    }

    if (root != null) {
        traverse(root, 0)
    }

    return levels
}

fun main() {
    val treeNode = TreeNode(3)
    treeNode.left = TreeNode(9)
    treeNode.right = TreeNode(20).apply {
        left = TreeNode(15)
        right = TreeNode(7)
    }

    val result = levelOrder(treeNode)

    println()
}