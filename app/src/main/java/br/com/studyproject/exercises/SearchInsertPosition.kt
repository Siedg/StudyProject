package br.com.studyproject.exercises

fun searchInsert(nums: IntArray, target: Int): Int {
    for (i in nums.indices) {
        if (nums[i] >= target) return i
    }
    if (nums.isNotEmpty()) return nums.size
    return 0
}

fun searchInsertBinary(nums: IntArray, target: Int): Int? {
    if (nums.isEmpty()) return null
    if (nums[0] > target) return 0
    if (nums[nums.lastIndex] < target) return nums.lastIndex + 1

    var left = 0
    var right = nums.lastIndex

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (nums[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }

    return left
}
