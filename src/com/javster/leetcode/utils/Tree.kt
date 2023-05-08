package com.javster.leetcode.utils

import kotlin.math.log2
import kotlin.math.pow

class NaryTreeNode(var `val`: Int) {
    var children: List<NaryTreeNode?> = listOf()
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun printInOrder(node: TreeNode?) {
    if (node == null) {
        return
    }
    node.left?.let { left ->
        printInOrder(left)
    }
    print("${node.`val`} ")
    node.right?.let { right ->
        printInOrder(right)
    }
}

fun treeOfIntsInOrder(a: Array<Int?>): TreeNode? {
    if (a.isEmpty()) {
        return null
    }

    var height: Int = log2(a.size.toDouble()).toInt()
    if (a.size > 2f.pow(height)) {
        height++
    }

    val lc = mutableMapOf<Int, Int>().apply {
        for (i in 0..height) {
            this[i] = 0
        }
    }

    fun subtree(node: TreeNode, level: Int) {
        if (level < height) {
            val indexBase = (2f.pow(level) - 1).toInt()
            val li = lc[level]!!

            val l = a[indexBase + li]
            node.left = if (l != null) TreeNode(l) else null
            val r = a[indexBase + li + 1]
            node.right = if (r != null) TreeNode(r) else null

            lc[level] = li + 2

            if (node.left != null)
                subtree(node.left!!, level + 1)
            if (node.right != null)
                subtree(node.right!!, level + 1)
        }
    }

    return if (a[0] != null) {
        val root = TreeNode(a[0]!!)
        subtree(root, 1)
        root
    } else {
        null
    }
}

fun main() {
//    printInOrder(treeOfIntsInOrder(arrayOf(4,2,7,1,3,6,9))!!)
    printInOrder(treeOfIntsInOrder(arrayOf(1, 2, 2, 3, 3, null, null, 4, 4, null, null, null, null, null, null))!!)
}