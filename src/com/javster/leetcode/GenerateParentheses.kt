package com.javster.leetcode

fun main() {
    generateParenthesis(4).forEach {
        println(it)
    }
}

data class TreeNode1(
    var str: String,
    val opensLeft: Int,
    val closesLeft: Int,
    var left: TreeNode1?,
    var right: TreeNode1?,
    var opensCount: Int = 0
)

fun generateParenthesis(n: Int): List<String> {
    val list = ArrayList<String>()
    val head = TreeNode1("", n, n, null, null)
    goingDeeper(head, list)
    return list
}

fun goingDeeper(parentNode: TreeNode1, list: ArrayList<String>) {
    if (parentNode.opensLeft == 0 && parentNode.closesLeft == 0) {
        list.add(parentNode.str)
        return
    }

    if (parentNode.opensLeft > 0) {
        val leftChild = TreeNode1(parentNode.str + "(", parentNode.opensLeft - 1, parentNode.closesLeft, null, null, parentNode.opensCount + 1)
        parentNode.left = leftChild
        goingDeeper(leftChild, list)
    }

    if (parentNode.closesLeft > 0 && parentNode.opensCount > 0) {
        val leftChild = TreeNode1(parentNode.str + ")", parentNode.opensLeft, parentNode.closesLeft - 1, null, null, parentNode.opensCount - 1)
        parentNode.left = leftChild
        goingDeeper(leftChild, list)
    }
}