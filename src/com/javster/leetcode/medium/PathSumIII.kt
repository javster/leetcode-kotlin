package com.javster.leetcode.medium

import com.javster.leetcode.utils.TreeNode
import com.javster.leetcode.utils.treeOfIntsInOrder

fun pathSum(root: TreeNode?, targetSum: Int): Int {
    if (root == null) {
        return 0
    }

    var counter = 0
    val sums = mutableMapOf<Long, Long>()

    fun traverse(node: TreeNode, sum: Long) {
        val newSum: Long = sum + node.`val`
        if (newSum == targetSum.toLong()) {
            counter++
        }

        val s = sums[newSum - targetSum] ?: 0
        if (s > 0) {
            counter += s.toInt()
        }

        val s1 = sums[newSum] ?: 0
        sums[newSum] = s1 + 1

        node.left?.let {
            traverse(it, newSum)
        }

        node.right?.let {
            traverse(it, newSum)
        }

        sums[newSum]?.let {
            sums[newSum] = Math.max(0, it - 1)
        }
    }

    traverse(root, 0)

    return counter
}

fun main() {
    println(pathSum(treeOfIntsInOrder(arrayOf(1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000)), 0))
    println(pathSum(treeOfIntsInOrder(arrayOf(-191,563,664,-875,988,198,-505,-420,795,957,null,536,-995,-681,821,381,-852,-506,-786,964,392,-675,-654,-717,479,-402,-223,-666,null,249,null,null,null,714,164,null,null,null,null,-580,null,null,652,-153,144,142,-776,906,-665,194,null,null,null,null,null,382,null,25,118,null,433,-754,53,701,null,-496,837,null,null,994,-440,null,-98,-456,852,-237,-159,null,92,628,-681,null,null,547,null,null,600,null,null,null,null,null,null,null,null,null,null,237,-127,795,null,null,null,316,53,-191,628,3,357,474,null,null,null,null,null,null,null,null,null,-746,-650,null,805,-201,750,null,null,null,null,-925,-237,null,-147,629,-769,null,null,null,-846,null,-776,null,null,null,null,null,null,null,null,null,null,-906,552,null,null,null,null,675,-832,594,null,-61,null,null,null,-291,-783,null,null,-660,null,789,null,null,-786,-853,null,-534,-321,-564,-398,358,-874,null,null,null,null,null,null,null,null,null,null,null,null,null,-598,null,null,null,null,null,593)), 8))
    println(pathSum(treeOfIntsInOrder(arrayOf(1, 0, 1, 1, 2, 0, -1, 0, 1, -1, 0, -1, 0, 1, 0)), 8))
    println(pathSum(treeOfIntsInOrder(arrayOf(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1, null, null, null, null)), 8))
    println(pathSum(treeOfIntsInOrder(arrayOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1, null, null, null)), 22))
    val fuckTree = TreeNode(1).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(5)
                }
            }
        }
    }
    println(pathSum(fuckTree, 15))

    val fuckTree1 = TreeNode(1).apply {
        right = TreeNode(2).apply {
            right = TreeNode(3).apply {
                right = TreeNode(4).apply {
                    right = TreeNode(5)
                }
            }
        }
    }
    println(pathSum(fuckTree1, 15))
}