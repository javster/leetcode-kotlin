package com.javster.leetcode

import java.lang.StringBuilder

val s1 = "54263634615765835050350580967174702085668435910635660620616543115335102947659612171353346993516240052"
val s2 = "78935008537672126746299935133570"
val answer =
    "4283300461680596944669060154993683109411015848461539623304116562284489755879014048314720713238997398179231541306472482175960803745640"

fun main() {
    println(multiply("123","456"))
    println(multiply("9999","9999"))
    println(multiply("15","15"))
    println(multiply("896686","8261335908"))
    require(multiply(s1, s2) == answer)
}

fun multiply(num1: String, num2: String): String {
    val zeroAscii = '0'.toInt()

    val digits1 = IntArray(num1.length) { i -> num1[num1.length - i - 1].toInt() - zeroAscii }
    val digits2 = IntArray(num2.length) { i -> num2[num2.length - i - 1].toInt() - zeroAscii }

    val result = IntArray(num1.length + num2.length + 1) { 0 }
    for (i in digits1.indices) {
        val digit1 = digits1[i]
        if (digit1 == 0) continue
        for (j in digits2.indices) {
            val digit2 = digits2[j]
            if (digit2 == 0) continue
            val position = i + j
            var sum = digit1 * digit2
            var pointer = position
            do {
                val temp = result[pointer] + sum
                result[pointer] = temp % 10
                sum = temp / 10
                pointer++
            } while (sum > 0)
        }
    }

    val sb = StringBuilder()
    var digitFound = false
    for (i in result.size - 1 downTo 0) {
        if (result[i] == 0 && !digitFound) continue
        digitFound = true
        sb.append(result[i])
    }
    if (!digitFound) {
        return "0"
    }

    return sb.toString()
}