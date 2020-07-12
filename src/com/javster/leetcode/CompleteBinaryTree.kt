package com.javster.leetcode

fun main() {
    val treeNode = TreeNode(1)

    treeNode.left = TreeNode(2).apply {
        left = TreeNode(4)
        right = TreeNode(5)
    }
    treeNode.right = TreeNode(3).apply {
        left = TreeNode(6)
    }

    println(CompleteBinaryTree().countNodes(treeNode))
}

class CompleteBinaryTree {
    var counter = 0

    fun countNodes(root: TreeNode?): Int {
        traverseTree(root)
        return counter
    }

    private fun traverseTree(root: TreeNode?) {
        if (root != null) {
            counter++
            if (root.left != null) {
                traverseTree(root.left)
            }
            if (root.right != null) {
                traverseTree(root.right)
            }
        }
    }
}