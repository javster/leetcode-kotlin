package com.javster.leetcode

fun main() {
    require(romanToInt("MCMXCIV") == 1994)
    require(romanToInt("LVIII") == 58)
    require(romanToInt("IX") == 9)
}

fun romanToInt(s: String): Int {
    if (s.isEmpty()) return 0
    var i = 0
    var sum = 0
    while (i < s.length) {
        var doubleIncrement = false
        when (s[i]) {
            'V' -> sum += 5
            'L' -> sum += 50
            'D' -> sum += 500
            'M' -> sum += 1000
            'I' -> {
                when {
                    i + 1 < s.length && s[i + 1] == 'V' -> {
                        doubleIncrement = true
                        sum += 4
                    }
                    i + 1 < s.length && s[i + 1] == 'X' -> {
                        doubleIncrement = true
                        sum += 9
                    }
                    else -> {
                        sum += 1
                    }
                }
            }
            'X' -> {
                when {
                    i + 1 < s.length && s[i + 1] == 'L' -> {
                        doubleIncrement = true
                        sum += 40
                    }
                    i + 1 < s.length && s[i + 1] == 'C' -> {
                        doubleIncrement = true
                        sum += 90
                    }
                    else -> {
                        sum += 10
                    }
                }
            }
            'C' -> {
                when {
                    i + 1 < s.length && s[i + 1] == 'D' -> {
                        doubleIncrement = true
                        sum += 400
                    }
                    i + 1 < s.length && s[i + 1] == 'M' -> {
                        doubleIncrement = true
                        sum += 900
                    }
                    else -> {
                        sum += 100
                    }
                }
            }
        }
        if (doubleIncrement) i++
        i++
    }
    return sum
}