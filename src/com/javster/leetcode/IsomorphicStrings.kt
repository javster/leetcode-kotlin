package com.javster.leetcode

fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    val sTot = mutableMapOf<Char, Char>()
    val tTos = mutableMapOf<Char, Char>()

    s.forEachIndexed { index, c1 ->
        val c2 = t[index]
        if (sTot[c1] == null) {
            if (tTos[c2] == null) {
                sTot[c1] = c2
                tTos[c2] = c1
            } else if (tTos[c2] != c1) {
                return false
            }
        }

        if (sTot[c1] != c2) {
            return false
        }
    }
    return true
}

fun main() {
    println(isIsomorphic("egg", "add"))
    println(isIsomorphic("foo", "bar"))
    println(isIsomorphic("paper", "title"))
    println(isIsomorphic("", "3"))
    println(isIsomorphic("badc", "baba"))
}