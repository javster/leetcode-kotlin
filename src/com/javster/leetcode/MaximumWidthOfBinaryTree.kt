package com.javster.leetcode

import com.javster.leetcode.utils.TreeNode

class MaximumWidthOfBinaryTree {
    var maxWidth = 0
    val leftmostPosition = mutableMapOf<Int, Int>()

    fun widthOfBinaryTree(root: TreeNode?): Int {
        traverse(root, 0, 0)
        return maxWidth
    }

    fun traverse(node: TreeNode?, level: Int, position: Int) {
        if (node == null) return
        leftmostPosition.computeIfAbsent(level) { _ -> position }
        maxWidth = Math.max(maxWidth, position - leftmostPosition[level]!! + 1)

        traverse(node.left, level + 1, position * 2)
        traverse(node.right, level + 1, position * 2 + 1)

    }
}