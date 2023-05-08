package com.javster.leetcode.stack


//Input: s = "ab#c", t = "ad#c"

fun backspaceCompare(s: String, t: String): Boolean {
    fun process(s: String): String {
        val list = mutableListOf<Char>()

        s.forEach { char ->
            if (char == '#') {
                if (list.size > 0) {
                    list.removeAt(list.size - 1)
                }
            } else {
                list.add(char)
            }
        }

        return String(list.toCharArray())
    }

    return process(s) == process(t)
}

fun main() {
//    println(backspaceCompare(s = "ab#c", t = "ad#c"))
//    println(backspaceCompare(s = "ab##", t = "c#d#"))
//    println(backspaceCompare(s = "a#c", t = "b"))
    println(backspaceCompare(s = "y#fo##f", t = "y#f#o##f"))
}