package br.com.studyproject.exercises

fun findMinimumInRotatedSortedArray(nums: IntArray): Int? {
    if (nums.isEmpty()) return null

    var left = 0
    var right = nums.lastIndex

    while (left < right) {
        val mid = left + (right - left) / 2

        if (nums[left] < nums[right]) return nums[left]

        if (nums[left] >= nums[mid]) {
            right = mid
        } else {
            left = mid + 1
        }
    }

    return nums[left]
}
