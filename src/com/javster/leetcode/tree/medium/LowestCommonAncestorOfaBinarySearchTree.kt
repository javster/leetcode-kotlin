package com.javster.leetcode.tree.medium

import com.javster.leetcode.utils.TreeNode

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null || p == null || q == null) {
        return null
    }

    val pPath = mutableListOf<TreeNode>()
    val qPath = mutableListOf<TreeNode>()

    fun fillPath(path: MutableList<TreeNode>, finalNode: TreeNode) {
        var node = root
        while (node != finalNode) {
            if (finalNode.`val` < node!!.`val`) {
                path.add(node)
                node = node.left
            }
            if (finalNode.`val` > node!!.`val`) {
                path.add(node)
                node = node.right
            }
        }
        path.add(node)
    }

    fillPath(pPath, p)
    fillPath(qPath, q)

    var i = 0
    var result: TreeNode? = null
    while (i < qPath.size && i < pPath.size && qPath[i] == pPath[i]) {
        result = qPath[i]
        i++
    }
    return result
}

//fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
//    if (root == null || p == null || q == null) {
//        return null
//    }
//
//    val path = mutableListOf<TreeNode>()
//
//    var node = root
//    while (node != p) {
//        if (p.`val` < node!!.`val`) {
//            path.add(node)
//            node = node.left
//        } else if (p.`val` > node!!.`val`) {
//            path.add(node)
//            node = node.right
//        }
//    }
//    path.add(node)
//
//    node = root
//    var i = 0
//    while (node != q && node == path[i++]) {
//        if (q.`val` < node.`val`) {
//            node = node.left
//        } else if (q.`val` > node!!.`val`) {
//            node = node.right
//        }
//    }
//    if (i > 0) {
//        i--
//    }
//    return path[i]
//}

fun main() {
    val root = TreeNode(6)
    val p = TreeNode(2)
    val q = TreeNode(4)
    root.left = p.apply {
        left = TreeNode(0)
        right = q.apply {
            left = TreeNode(3)
            right = TreeNode(5)
        }
    }
    root.right = TreeNode(8).apply {
        left = TreeNode(7)
        right = TreeNode(9)
    }
    println(lowestCommonAncestor(root, p, q)!!.`val`)
}