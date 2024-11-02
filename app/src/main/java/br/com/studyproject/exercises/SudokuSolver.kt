package br.com.studyproject.exercises

class SudokuSolver {
    fun solveSudoku(board: Array<CharArray>) {
        solve(board)
    }

    private fun solve(board: Array<CharArray>): Boolean {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (board[i][j] == '.') {
                    for (num in '1'..'9') {
                        if (isValid(board, i, j, num)) {
                            board[i][j] = num
                            if (solve(board)) return true
                            board[i][j] = '.'
                        }
                    }
                    return false
                }
            }
        }
        return true
    }

    private fun isValid(board: Array<CharArray>, row: Int, col: Int, num: Char): Boolean {
        for (i in 0 until 9) {
            if (board[row][i] == num || board[i][col] == num) return false
            val boxRow = 3 * (row / 3) + i / 3
            val boxCol = 3 * (col / 3) + i % 3
            if (board[boxRow][boxCol] == num) return false
        }
        return true
    }
}