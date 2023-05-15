package com.javster.leetcode.trie.medium

class Trie {

    data class Node(
        val letters: MutableMap<Int, Node> = mutableMapOf(),
        var isWord: Boolean = false
    )

    var root = Node()

    fun insert(word: String) {
        var node = root
        word.forEach { l ->
            val c = l.toInt() - 'a'.toInt()
            if (!node.letters.contains(c)) {
                node.letters[c] = Node()
            }
            node = node.letters[c]!!
        }
        node.isWord = true
    }

    fun search(word: String): Boolean {
        var node = root
        var i = 0
        while (node.letters.isNotEmpty() && i < word.length) {
            val c = word[i].toInt() - 'a'.toInt()
            if (node.letters[c] != null) {
                node = node.letters[c]!!
                i++
            } else {
                return false
            }
        }
        return i == word.length && node.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var node = root
        var i = 0
        while (node.letters.isNotEmpty() && i < prefix.length) {
            val c = prefix[i].toInt() - 'a'.toInt()
            if (node.letters[c] != null) {
                node = node.letters[c]!!
                i++
            } else {
                return false
            }
        }
        return i == prefix.length
    }
}

fun main() {
    val trie = Trie()
    with(trie) {
        insert("apple");
        println(search("apple"))   // return True
        println(search("app"))     // return False
        println(startsWith("app"))
        insert("app")
        println(search("app"))
    }
}

