package com.javster.leetcode

import java.lang.StringBuilder

fun main() {
    println(backspaceCompare("as", "asd"))
}

fun backspaceCompare(S: String, T: String): Boolean {
    val mS = modify(S)
    val mT = modify(T)
    return mT == mS
}

private fun modify(s: String): String {
    val sb = StringBuilder()
    return s.fold(sb) { _, it ->
        if (it == '#') {
            if (sb.isNotEmpty())
                sb.deleteCharAt(sb.length - 1)
        } else {
            sb.append(it)
        }
        sb
    }.toString()
}