package com.javster.leetcode

fun main() {
    val board = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
    )
    println(isValidSudoku(board))

    val board1 = arrayOf(
        charArrayOf('.','.','.','.','5','.','.','1','.'),
        charArrayOf('.','4','.','3','.','.','.','.','.'),
        charArrayOf('.','.','.','.','.','4','.','.','1'),
        charArrayOf('8','.','.','.','.','.','.','2','.'),
        charArrayOf('.','.','2','.','7','.','.','.','.'),
        charArrayOf('.','1','5','.','.','.','.','.','.'),
        charArrayOf('.','.','.','.','.','2','.','.','.'),
        charArrayOf('.','2','.','9','.','.','.','.','.'),
        charArrayOf('.','.','4','.','.','.','.','.','.')
    )
    println(isValidSudoku(board1))

    val subboxes = HashMap<Int, ArrayList<Char>>()
    println(getSubbox(subboxes, 3, 3))
}

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val rows = HashMap<Int, ArrayList<Char>>()
    val columns = HashMap<Int, ArrayList<Char>>()
    val subboxes = HashMap<Int, ArrayList<Char>>()
    for (i in board.indices) {
        val row = getLine(rows, i)
        for (j in board[i].indices) {
            val column = getLine(columns, j)
            val subbox = getSubbox(subboxes, i, j)
            val c = board[i][j]
            if (c != '.') {
                if (row.contains(c) || column.contains(c) || subbox.contains(c)) {
                    return false
                } else {
                    row.add(c)
                    column.add(c)
                    subbox.add(c)
                }
            }
        }
    }

    return true
}

private fun getSubbox(subboxes: HashMap<Int, ArrayList<Char>>, i: Int, j: Int): ArrayList<Char> {
    val index = j / 3 + (i / 3) * 3
    var subbox = subboxes[index]
    if (subbox == null) {
        subboxes[index] = ArrayList()
        subbox = subboxes[index]
    }
    return subbox!!
}

private fun getLine(line: HashMap<Int, ArrayList<Char>>, i: Int): ArrayList<Char> {
    var row = line[i]
    if (row == null) {
        line[i] = ArrayList()
        row = line[i]
    }
    return row!!
}