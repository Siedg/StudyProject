package br.com.studyproject.exercises

fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.lastIndex
    var maxArea = 0

    while (left < right) {
        val area = minOf(height[left], height[right]) * (right - left)
        maxArea = maxOf(maxArea, area)

        if (height[left] < height[right]) left++
        else right--
    }

    return maxArea
}
