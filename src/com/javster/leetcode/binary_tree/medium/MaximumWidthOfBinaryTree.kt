package com.javster.leetcode.binary_tree.medium

import com.javster.leetcode.utils.TreeNode
import kotlin.math.max

fun widthOfBinaryTree(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    val matrix = mutableListOf<MutableList<Int?>>()
    val counters = mutableListOf<Int>()
    var height = 0

    fun findHeight(node: TreeNode, level: Int) {
        if (level > height) {
            height = level
        }
        if (node.left != null) {
            findHeight(node.left!!, level + 1)
        }
        if (node.right != null) {
            findHeight(node.right!!, level + 1)
        }
    }

    fun fillTree(node: TreeNode, level: Int) {
        if (level > height) {
            return
        }

        if (node.left != null) {
            fillTree(node.left!!, level + 1)
        } else if (level < height) {
            node.left = TreeNode(Int.MAX_VALUE)
            fillTree(node.left!!, level + 1)
        }

        if (node.right != null) {
            fillTree(node.right!!, level + 1)
        } else if (level < height) {
            node.right = TreeNode(Int.MAX_VALUE)
            fillTree(node.right!!, level + 1)
        }
    }

    fun traverse(node: TreeNode, level: Int) {
        if (node.left != null) {
            traverse(node.left!!, level + 1)
        }

        while (matrix.size <= level) {
            matrix.add(mutableListOf())
        }
        while (counters.size <= level) {
            counters.add(0)
        }

        matrix[level].add(node.`val`)
        counters[level] = counters[level] + 1

        if (node.right != null) {
            traverse(node.right!!, level + 1)
        }
    }

    findHeight(root, 0)
    fillTree(root, 0)
    traverse(root, 0)

    var maxWidth = 0
    for (i in matrix.indices) {
        var firstFound: Int? = null
        var lastFound: Int? = null
        for (j in matrix[i].indices) {
            val element = matrix[i][j]
            if (element != Int.MAX_VALUE) {
                if (firstFound == null) {
                    firstFound = j
                } else {
                    lastFound = j
                }
            }
        }
        if (firstFound != null) {
            if (lastFound != null) {
                var width = lastFound - firstFound + 1
                maxWidth = max(width, maxWidth)
                if (width > maxWidth) {
                    maxWidth = width
                }
            } else {
                maxWidth = max(1, maxWidth)
            }
        }
    }
    return maxWidth
}

fun main() {
    val root = TreeNode(1)
    root.left = TreeNode(3).apply {
        left = TreeNode(5).apply {
            left = TreeNode(6)
        }
    }
    root.right = TreeNode(2).apply {
        right = TreeNode(9).apply {
            left = TreeNode(7)
            right = TreeNode(9)
        }
    }

    val newroot = TreeNode(1)

    println(widthOfBinaryTree(newroot))
}

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