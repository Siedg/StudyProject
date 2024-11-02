package br.com.studyproject.exercises

class NQueens {
    fun solveNQueens(n: Int): List<List<String>> {
        val solutions = mutableListOf<List<String>>()
        val board = Array(n) { CharArray(n) { '.' } }
        solve(0, board, solutions)
        return solutions
    }

    fun solve(row: Int, board: Array<CharArray>, solutions: MutableList<List<String>>) {
        val n = board.size
        if (row == n) {
            solutions.add(board.map { it.joinToString("") })
            return
        }

        for (col in 0 until n) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q'
                solve(row + 1, board, solutions)
                board[row][col] = '.'
            }
        }
    }

    fun isSafe(row: Int, col: Int, board: Array<CharArray>): Boolean {
        for (i in 0 until row) {
            if (board[i][col] == 'Q') return false
        }

        var i = row - 1
        var j = col - 1
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') return false
            i--; j--
        }

        i = row - 1
        j = col + 1
        while (i >= 0 && j < board.size) {
            if (board[i][j] == 'Q') return false
            i--; j++
        }

        return true
    }
}
