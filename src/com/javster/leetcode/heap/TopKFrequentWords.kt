package com.javster.leetcode.heap

fun topKFrequent(words: Array<String>, k: Int): List<String> {
    data class Frequency(val word: String, val count: Int)

    val frequencyComparator = Comparator<Frequency> { o1, o2 -> o1.count - o2.count }

    val map = mutableMapOf<String, Int>()

    words.forEach { word ->
        if (map.contains(word)) {
            map[word] = map[word]!! + 1
        } else {
            map[word] = 1
        }
    }

    val list = mutableListOf<Frequency>()
    map.forEach { (word, count) ->
        list.add(Frequency(word, count))
    }
    list.sortedWith(frequencyComparator)

    val lastK = list.subList(0, k)
    val strings = lastK.fold(mutableListOf<String>()) { acc, el ->
        acc.add(el.word)
        acc
    }
    strings.sort()

    return strings
}

fun main() {
    topKFrequent(arrayOf("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), k = 4).forEach {
        print("$it ")
    }
}