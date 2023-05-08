package com.javster.leetcode.trie

class Solution {
    private var max: String = ""

    class Trie(
        val links: Array<Trie?> = Array(26) {
            null
        },
        var isWord: Boolean = false,
        var linksCount: Int = 0
    )

    private fun insert(string: String, root: Trie) {
        var node = root
        string.forEachIndexed { index, key ->
            val i = (key - 'a')
            if (node.links[i] != null) {
                node = node.links[i]!!
            } else {
                val n = Trie()
                node.links[i] = n
                node.linksCount++
                node = node.links[i]!!
            }
            if (index == string.lastIndex) {
                node.isWord = true
            }
        }
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1) {
            return strs[0]
        }
        val root = Trie()
        strs.forEach {
            if (it.isEmpty()) {
                return ""
            }
            insert(it, root)
        }

        dfs(root)
        return max
    }

    fun dfs(root: Trie) {
        var node = root
        val sb = StringBuffer()
        while (node.linksCount == 1 && !node.isWord) {
            node.links.forEachIndexed { i, t ->
                if (t != null) {
                    val c = ('a' + i)
                    sb.append(c)
                    node = t
                }
            }
        }
        max = sb.toString()
    }
}

fun main() {
    println(Solution().longestCommonPrefix(arrayOf("froolic","froolic","fraodf","frloadsf","frlozcv")))
    println(Solution().longestCommonPrefix(arrayOf("a", "ab")))
    println(Solution().longestCommonPrefix(arrayOf("flower", "flow", "flight")))
    println(Solution().longestCommonPrefix(arrayOf("dog", "racecar", "car")))
    println(Solution().longestCommonPrefix(arrayOf("flower", "flow", "flood")))
    println(Solution().longestCommonPrefix(arrayOf("a")))
    println(Solution().longestCommonPrefix(arrayOf("", "a")))
}
