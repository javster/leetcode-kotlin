package com.javster.leetcode

fun main() {
    with (ReverseWords()) {
        println(reverseWords("the sky is blue"))
        println(reverseWords("  hello world!  "))
        println(reverseWords("a good   example"))
    }
}

class ReverseWords {

    fun reverseWords(s: String): String {
        val words = mutableListOf<String>()
        if (s.isEmpty()) {
            return s
        }
        var index = 0
        while (index < s.length) {
            if (s[index] != ' ') {
                index = processWord(s, index, words)
            }
            index++
        }
        return StringBuffer().apply {
            words.reversed().forEach {
                append("$it ")
            }
        }.toString().trim()
    }

    fun processWord(s: String, start: Int, words: MutableList<String>): Int {
        var index = start
        while (index < s.length && s[index] != ' ') {
            index++
        }
        words.add(s.substring(start, index))
        return index - 1
    }
}