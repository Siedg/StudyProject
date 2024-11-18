package br.com.studyproject.exercises

fun largestNumberSmallerThanTarget(nums: IntArray, target: Int): Int? {
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

    return if (left > 0 && nums[left - 1] < target) return nums[left -1 ] else null
}
