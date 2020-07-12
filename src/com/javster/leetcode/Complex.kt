package com.javster.leetcode

fun main() {
//    println(com.javster.leetcode.complexNumberMultiply("1+1i", "1+1i"))
    println(complexNumberMultiply("1+-1i", "1+-1i"))
}

fun complexNumberMultiply(a: String, b: String): String {
    val firstDigits = a.split("+")
    val secondDigits = b.split("+")

    fun tryToParse(string: String) =
        Integer.parseInt(string)

    var realCounter = 0
    var imaginaryCounter = 0
    for (i in firstDigits) {
        val isVal1Imaginary = i.last() == 'i'
        var value1 = if (isVal1Imaginary) tryToParse(i.substring(0, i.length - 1)) else tryToParse(i)
        for (j in secondDigits) {
            val isVal2Imaginary = j.last() == 'i'
            var value2 = if (isVal2Imaginary) tryToParse(j.substring(0, j.length - 1)) else tryToParse(j)
            if (isVal1Imaginary && isVal2Imaginary) {
                realCounter -= value1 * value2
            } else if (isVal1Imaginary || isVal2Imaginary) {
                imaginaryCounter += value1 * value2
            } else {
                realCounter += value1 * value2
            }
        }

    }
    return "$realCounter+${imaginaryCounter}i"

}