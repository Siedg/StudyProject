package br.com.studyproject.exercises

class MaximalRectangle {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return 0

        val cols = matrix[0].size
        val heights = IntArray(cols) { 0 }
        var maxArea = 0

        for (row in matrix) {
            for (j in 0 until cols) {
                heights[j] = if (row[j] == '1') heights[j] + 1 else 0
            }
            maxArea = maxOf(maxArea, largestRectangleArea(heights))
        }

        return maxArea
    }

    fun largestRectangleArea(heights: IntArray): Int {
        val stack = mutableListOf<Int>()
        var maxArea = 0
        for (i in heights.indices) {
            while (stack.isNotEmpty() && heights[i] < heights[stack.last()]) {
                val h = heights[stack.removeAt(stack.size - 1)]
                val width = if (stack.isEmpty()) i else i - stack.last() - 1
                maxArea = maxOf(maxArea, h * width)
            }
            stack.add(i)
        }
        while (stack.isNotEmpty()) {
            val h = heights[stack.removeAt(stack.size - 1)]
            val width = if (stack.isEmpty()) heights.size else heights.size - stack.last() - 1
            maxArea = maxOf(maxArea, h * width)
        }
        return maxArea
    }
}
