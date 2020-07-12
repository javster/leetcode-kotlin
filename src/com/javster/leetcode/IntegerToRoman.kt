package com.javster.leetcode

fun main() {
    require(intToRoman(3) == "III")
    require(intToRoman(4) == "IV")
    require(intToRoman(9) == "IX")
    require(intToRoman(58) == "LVIII")
    require(intToRoman(1994) == "MCMXCIV")
}

fun intToRoman(num: Int): String {
    var number = num
    val sb = StringBuilder()
    while (number > 0) {
        when (number) {
            in 900..Int.MAX_VALUE -> {
                val thousands = number / 1000
                number %= if (thousands > 0) {
                    addDigitNTime(sb, "M", thousands)
                    1000
                } else {
                    addDigitNTime(sb, "CM")
                    900
                }
            }
            in 400 until 900 -> {
                val fiveHundreds = number / 500
                number %= if (fiveHundreds > 0) {
                    addDigitNTime(sb, "D", fiveHundreds)
                    500
                } else {
                    addDigitNTime(sb, "CD")
                    400
                }
            }
            in 90 until 400 -> {
                val hundreds = number / 100
                number %= if (hundreds > 0) {
                    addDigitNTime(sb, "C", hundreds)
                    100
                } else {
                    addDigitNTime(sb, "XC")
                    90
                }
            }
            in 40 until 90 -> {
                val fifties = number / 50
                number %= if (fifties > 0) {
                    addDigitNTime(sb, "L", fifties)
                    50
                } else {
                    addDigitNTime(sb, "XL")
                    40
                }
            }
            in 9 until 40 -> {
                val tens = number / 10
                number %= if (tens > 0) {
                    addDigitNTime(sb, "X", tens)
                    10
                } else {
                    addDigitNTime(sb, "IX")
                    9
                }
            }
            in 4 until 9 -> {
                val fives = number / 5
                number %= if (fives > 0) {
                    addDigitNTime(sb, "V", fives)
                    5
                } else {
                    addDigitNTime(sb, "IV")
                    4
                }
            }
            in 1 until 4 -> {
                addDigitNTime(sb, "I", number)
                number = 0
            }
        }
    }
    return sb.toString()
}

fun addDigitNTime(sb: StringBuilder, latinNumber: String, counter: Int = 1) {
    for (i in 0 until counter) {
        sb.append(latinNumber)
    }
}