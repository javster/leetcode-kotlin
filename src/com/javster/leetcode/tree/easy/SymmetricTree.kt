package com.javster.leetcode.tree.easy

import com.javster.leetcode.utils.TreeNode
import com.javster.leetcode.utils.treeOfIntsInOrder

class SymmetricTree {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }

        if (root.left == null && root.right == null) {
            return true
        }

        fun traverse(left: TreeNode?, right: TreeNode?): Boolean {
            if (left == null && right == null) {
                return true
            }
            if (left?.`val` != right?.`val`) {
                return false
            }
            return traverse(left!!.left, right!!.right) && traverse(left.right, right.left)
        }

        return traverse(root.left, root.right)
    }
}

fun main() {
    val root = treeOfIntsInOrder(arrayOf(1,2,2,3,4,4,3))
    val s = SymmetricTree()
    println(s.isSymmetric(root))
}