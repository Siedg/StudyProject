package br.com.studyproject.exercises

fun binarySearchForRange(nums: IntArray, target: Int): Pair<Int, Int>? {
    if (nums.isEmpty()) return null

    var left = 0
    var right = nums.lastIndex
    var foundIndex = -1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (nums[mid] == target) {
            foundIndex = mid
            break
        } else if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    if (foundIndex == -1) return null

    var start = foundIndex
    left = 0
    right = start
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            start = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }

    var end = foundIndex
    left = foundIndex
    right = nums.lastIndex
    while (left <= right) {
        val mid = left + (right - left) / 2
        if (nums[mid] == target) {
            end = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return Pair(start, end)
}
