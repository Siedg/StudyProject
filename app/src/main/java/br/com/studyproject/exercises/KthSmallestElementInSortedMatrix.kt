package br.com.studyproject.exercises

import java.util.PriorityQueue

fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return -1

    val n = matrix.size
    val minHeap = PriorityQueue<Pair<Int, Pair<Int, Int>>>(compareBy { it.first })

    for (i in 0 until n) {
        minHeap.add(Pair(matrix[i][0], Pair(i, 0)))
    }

    var count = 0
    var result = -1
    while (count < k) {
        val (value, pair) = minHeap.poll()
        val (row, col) = pair
        result = value
        count++

        if (col + 1 < matrix[row].size) {
            minHeap.add(Pair(matrix[row][col + 1], Pair(row, col + 1)))
        }
    }

    return result
}
