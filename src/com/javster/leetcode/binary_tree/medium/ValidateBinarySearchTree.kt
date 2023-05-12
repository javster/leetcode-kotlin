package com.javster.leetcode.binary_tree.medium

import com.javster.leetcode.utils.TreeNode

fun isValidBST(root: TreeNode?): Boolean {
    if (root == null) {
        return false
    }
    val nodesLTR = mutableListOf<Int>()
    fun traverse(node: TreeNode) {
        if (node.left != null) {
            traverse(node.left!!)
        }
        nodesLTR.add(node.`val`)
        if (node.right != null) {
            traverse(node.right!!)
        }
    }
    traverse(root)
    for (i in 0 until nodesLTR.size - 1) {
        if (nodesLTR[i] >= nodesLTR[i + 1]) {
            return false
        }
    }
    return true
}

fun main() {

    val treeNode = TreeNode(20)
    treeNode.left = TreeNode(8).apply {
        left = TreeNode(7)
        right = TreeNode(19)
    }
    treeNode.right = TreeNode(22).apply {
        left = TreeNode(21)
    }
    println(isValidBST(treeNode))
}