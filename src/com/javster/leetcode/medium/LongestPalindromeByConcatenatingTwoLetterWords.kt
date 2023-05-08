package com.javster.leetcode.medium

fun longestPalindrome(words: Array<String>): Int {
    val wordCounters = mutableMapOf<String, Int>()
    val twinLetters = mutableSetOf<String>()
    var twinLetterWords = 0
    var symmetricPairs = 0
    words.forEach { word ->
        val count = wordCounters[word] ?: 0
        wordCounters[word] = count + 1
        if (word == word.reversed()) {
            twinLetters.add(word)
        }
    }
    words.forEach { word ->
        val reversedWord = word.reversed()
        val counter = wordCounters[word] ?: 0
        val reversedCounter = wordCounters[reversedWord] ?: 0
        val isTwins = word == reversedWord
        if (isTwins) {
            if (counter > 1) {
                wordCounters[word] = counter - 2
                symmetricPairs++
            }
        } else if (counter > 0 && reversedCounter > 0) {
            wordCounters[word] = counter - 1
            wordCounters[reversedWord] = reversedCounter - 1
            symmetricPairs++
        }
    }

    twinLetters.forEach {
        if ((wordCounters[it] ?: 0) > 0) {
            twinLetterWords = 1
            return@forEach
        }
    }

    return symmetricPairs * 4 + twinLetterWords * 2
}

fun main() {
    require(longestPalindrome(arrayOf("dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc")) == 22)
    require(longestPalindrome(arrayOf("lc", "cl", "gg")) == 6)
    require(longestPalindrome(arrayOf("ab", "ty", "yt", "lc", "cl", "ab")) == 8)
    require(longestPalindrome(arrayOf("cc", "ll", "xx")) == 2)
    require(longestPalindrome(arrayOf("gg")) == 2)
    require(longestPalindrome(arrayOf("gd")) == 0)
}