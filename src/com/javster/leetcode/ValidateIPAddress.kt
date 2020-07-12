package com.javster.leetcode

import java.lang.NumberFormatException

fun main() {
    val validator = ValidateIPAddress()
    println(validator.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334"))
    println(validator.validIPAddress("1.2.3.4"))
    println(validator.validIPAddress("1.2.3.444"))
    println(validator.validIPAddress("1.2.3.255"))
    println(validator.validIPAddress("-1.2.3.4"))
    println(validator.validIPAddress("-0.2.3.4"))
    println(validator.validIPAddress("-1.2.3.4"))
    println(validator.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334"))
}

class ValidateIPAddress {

    val ipv4 = Regex("[0-9\\.]+")
    val ipv6 = Regex("[a-zA-Z0-9\\:]+")

    fun validIPAddress(IP: String) =
        when {
            isIPv4(IP) -> {
                "IPv4"
            }
            isIPv6(IP) -> {
                "IPv6"
            }
            else -> {
                "Neither"
            }
        }


    private fun isIPv4(ip: String): Boolean {
        if (!ipv4.matches(ip)) return false
        val sections = ip.split(".")

        if (sections.size == 4) {
            sections.forEach {
                val number = try {
                    Integer.parseInt(it)
                } catch (nfe: NumberFormatException) {
                    return false
                }
                if (number < 0 || number > 255) {
                    return false
                }
                if ((number > 0 || it.length > 1) && it.startsWith("0")) {
                    return false
                }
            }
        } else {
            return false
        }

        return true
    }

    private fun isIPv6(ip: String): Boolean {
        if (!ipv6.matches(ip)) return false

        val sections = ip.split(":")

        if (sections.size == 8) {
            sections.forEachIndexed { index, it ->
                if (it.length > 4) {
                    return false
                }
                val number = try {
                    Integer.parseInt(it, 16)
                } catch (nfe: NumberFormatException) {
                    return false
                }
                if (number < 0 || number > 65535) {
                    return false
                }
                if (index == 0 && number > 0 && it.startsWith("0")) {
                    return false
                }
            }
        } else {
            return false
        }

        return true
    }
}