package com.javster.leetcode

import com.javster.leetcode.utils.TreeNode

fun main() {
    val root = TreeNode(3).apply {
        left = TreeNode(9)
        right = TreeNode(20).apply {
            left = TreeNode(15)
            right = TreeNode(7)
        }
    }
    println(BinaryTreeLevelOrderTraversalII().levelOrderBottom(root))
}

class BinaryTreeLevelOrderTraversalII {
    private val levels = ArrayList<ArrayList<Int>>()

    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        root?.let { traverseLevel(root, 0) }
        return levels.reversed()
    }

    private fun traverseLevel(root: TreeNode, level: Int) {
        if (levels.size <= level) {
            levels.add(ArrayList())
        }
        val levelValues = levels[level]
        levelValues.add(root.`val`)

        root.left?.let {
            traverseLevel(root.left!!, level + 1)
        }

        root.right?.let {
            traverseLevel(root.right!!, level + 1)
        }
    }
}