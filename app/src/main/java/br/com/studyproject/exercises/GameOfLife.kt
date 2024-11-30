package br.com.studyproject.exercises

var maxLines = 0
var maxColumns = 0
fun gameOfLife(board: Array<IntArray>): Unit {
    if (board.isEmpty()) return
    maxLines = board.lastIndex
    maxColumns = board[0].lastIndex
    val result = MutableList(maxLines + 1) { MutableList(maxColumns + 1) { 0 } }
    val coords = mutableListOf<Pair<Int, Int>>()

    coords.add(Pair(-1, -1)) // left up
    coords.add(Pair(0, -1)) // left
    coords.add(Pair(-1, 1)) // right up
    coords.add(Pair(-1, 0)) // up
    coords.add(Pair(1, 0)) // down
    coords.add(Pair(0, 1)) // right
    coords.add(Pair(1, -1)) // down left
    coords.add(Pair(1, 1)) // down right

    for (i in 0..maxLines) {
        var zeroCount = 0
        var oneCount = 0
        for (j in 0..maxColumns) {
            coords.forEach {
                if (isValid(i + it.first, j + it.second)) {
                    if (board[i + it.first][j + it.second] == 0) zeroCount++
                    else oneCount++
                }
            }
            if (board[i][j] == 1) {
                if (oneCount < 2 || oneCount > 3) result[i][j] = 0
                else result[i][j] = 1
            }
            else {
                if (oneCount == 3) result[i][j] = 1
                else result[i][j] = 0
            }

            zeroCount = 0
            oneCount = 0
        }
    }

    for (i in board.indices) {
        for (j in board[0].indices) {
            board[i][j] = result[i][j]
        }
    }
}

fun isValid(line: Int, column: Int): Boolean {
    return (line in 0..maxLines
            && column in 0..maxColumns)
}
