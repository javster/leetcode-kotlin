package com.javster.leetcode

import com.javster.leetcode.utils.NaryTreeNode

fun preorder(root: NaryTreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    if (root != null) {
        result.add(root.`val`)
    }

    val children = root?.children ?: emptyList()
    children.forEach {
        result.addAll(preorder(it))
    }

    return result
}

fun main() {
    val head = NaryTreeNode(1).apply {
        val child1 = NaryTreeNode(3).apply {
            children = mutableListOf(NaryTreeNode(5), NaryTreeNode(6))
        }
        val child2 = NaryTreeNode(2)
        val child3 = NaryTreeNode(4)
        children = mutableListOf(child1, child2, child3)
    }
    for (i in preorder(head)) {
        println(i)
    }
}