package com.javster.leetcode.binary_tree.medium

import com.javster.leetcode.utils.TreeNode

fun kthSmallest(root: TreeNode?, k: Int): Int {
    if (root == null) {
        return -1
    }
    var i = 0
    fun traverseLeftFirst(node: TreeNode): Int? {
        node.left?.let {
            traverseLeftFirst(it)?.let { left ->
                return left
            }
        }
        if (i++ == k) {
            return node.`val`
        }
        node.right?.let {
            traverseLeftFirst(it)?.let { right ->
                return right
            }
        }
        return null
    }

    return traverseLeftFirst(root) ?: -1
}

fun main() {
    val root = TreeNode(5).apply {
        left = TreeNode(3).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
            }
            right = TreeNode(4)
        }
        right = TreeNode(6)
    }
    println(kthSmallest(root, 3))
}