package br.com.studyproject.exercises

fun rotate(matrix: Array<IntArray>): Unit {
    val n = matrix.size

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }

    for (i in 0 until n) {
        var left = 0
        var right = n - 1
        while (left < right) {
            val temp = matrix[i][left]
            matrix[i][left] = matrix[i][right]
            matrix[i][right] = temp
            left++
            right--
        }
    }
}
