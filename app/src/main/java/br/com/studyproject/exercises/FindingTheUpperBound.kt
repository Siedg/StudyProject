package br.com.studyproject.exercises

fun findingTheUpperBound(nums: IntArray, target: Int): Int? {
    if (nums.isEmpty()) return null

    var left = 0
    var right = nums.lastIndex

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (nums[mid] <= target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return left
}
