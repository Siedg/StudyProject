package br.com.studyproject.exercises

class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { mutableSetOf<Char>() }
        val columns = Array(9) { mutableSetOf<Char>() }
        val boxes = Array(9) { mutableSetOf<Char>() }

        for (i in board.indices) {
            for (j in board[i].indices) {
                val num = board[i][j]
                if (num != '.') {
                    val boxIndex = (i / 3) * 3 + j / 3

                    if (num in rows[i] || num in columns[j] || num in boxes[boxIndex]) {
                        return false
                    }

                    rows[i].add(num)
                    columns[j].add(num)
                    boxes[boxIndex].add(num)
                }
            }
        }
        return true
    }

}