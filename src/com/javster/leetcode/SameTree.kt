package com.javster.leetcode

import com.sun.source.tree.Tree
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val p = TreeNode(1).apply {
        left = TreeNode(2)
    }

    val q = TreeNode(1).apply {
        right = TreeNode(2)
    }

    println(SameTree().isSameTree(p, q))
}

class SameTree {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return traverseTree(p, q)
    }

    private fun traverseTree(pNode: TreeNode?, qNode: TreeNode?): Boolean {
        if (pNode == null && qNode == null) {
            return true
        } else if ((pNode == null) xor (qNode == null)) {
            return false
        }

        if (pNode?.`val` != qNode?.`val`) {
            return false
        }

        if (!traverseTree(pNode!!.left, qNode!!.left)) {
            return false
        }

        if (!traverseTree(pNode.right, qNode.right)) {
            return false
        }

        return true
    }
}