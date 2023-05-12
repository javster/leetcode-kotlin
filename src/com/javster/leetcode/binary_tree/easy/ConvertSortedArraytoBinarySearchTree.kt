package com.javster.leetcode.binary_tree.easy

import com.javster.leetcode.utils.TreeNode
import com.javster.leetcode.utils.printInOrder

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    fun tree(p: Int, r: Int): TreeNode? {
        if (p > r) {
            return null
        }
        val q = (p + r) / 2
        return TreeNode(nums[q]).apply {
            left = tree(p, q - 1)
            right = tree(q + 1, r)
        }
    }

    return tree(0, nums.size - 1)
}

fun main() {
    printInOrder(sortedArrayToBST(intArrayOf(-10,-3,0,5,9)))
    printInOrder(sortedArrayToBST(intArrayOf(-10,-3,0,5,9)))
}