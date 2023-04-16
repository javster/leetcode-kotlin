package com.javster.leetcode

fun main() {
//    println(RegularExpressionMatching().isMatch("aa", "a"))
//    println(RegularExpressionMatching().isMatch("aa", "a*"))
//    println(RegularExpressionMatching().isMatch("ab", ".*"))
//    println(RegularExpressionMatching().isMatch("aab", "c*a*b"))
//    println(RegularExpressionMatching().isMatch("mississippi", "mis*is*ip*."))
//    println(RegularExpressionMatching().isMatch("ab", ".*c"))
//    println(RegularExpressionMatching().isMatch("aaa", "a*a"))
    println(RegularExpressionMatching().isMatch("aaa", "ab*a*c*a"))

}

class RegularExpressionMatching {

    private val tokens = ArrayList<Token>()

    fun analyzePattern(p: String) {
        var i = 0
        while (i < p.length) {
            when (p[i]) {
                '.' -> {
                    if (i + 1 < p.length && p[i + 1] == '*') {
                        tokens.add(Star(p[i]))
                        i++
                    } else {
                        tokens.add(AnySymbol())
                    }
                }
                else -> {
                    if (i + 1 < p.length && p[i + 1] == '*') {
                        tokens.add(Star(p[i]))
                        i++
                    } else {
                        tokens.add(Symbol(p[i]))
                    }
                }
            }
            i++
        }

        i = 0
        while (i < tokens.size) {
            if (tokens[i] is Star) {
                if (i + 1 < tokens.size) {
                    if (tokens[i + 1] is Symbol) {
                        val t = tokens[i] as Star
                        val t1 = tokens[i + 1] as Symbol
                        if (t1.c == t.c) {
                            tokens.removeAt(i + 1)
                            continue
                        }
                    }
                }
            }
            i++
        }
    }

    fun isMatch(s: String, p: String): Boolean {
        analyzePattern(p)

        var stringIndex = 0
        var tokenId = 0

        var lastStarToken: Star? = null

        while (stringIndex < s.length && tokenId < tokens.size) {
            val token = tokens[tokenId]
            if (lastStarToken != null) {
                if (token is Symbol) {
                    if (lastStarToken.c == token.c) {
                        tokenId++
                    }
                }
            }
            val result = token.process(s, stringIndex)
            if (result == -1) return false else {
                if (token is Star && result > stringIndex) {
                    lastStarToken = token
                }
                tokenId++
                stringIndex = result
            }
        }

        return tokenId == tokens.size && stringIndex == s.length
    }

    interface Token {
        fun process(s: String, i: Int): Int
    }

    class Symbol(val c: Char) : Token {
        override fun process(s: String, i: Int): Int {
            if (s[i] == c) {
                return i + 1
            }
            return -1
        }

    }

    class Star(val c: Char) : Token {
        override fun process(s: String, index: Int): Int {
            if (index == s.length + 1) return -1
            var i = index
            do {
                val ch = s[i]
                if (c == '.' || ch == c) {
                    i++
                }
            } while ((c == '.' || ch == c) && i < s.length)
            return i
        }

    }

    class AnySymbol : Token {
        override fun process(s: String, i: Int): Int {
            if (i == s.length + 1) return -1
            return i + 1
        }

    }
}