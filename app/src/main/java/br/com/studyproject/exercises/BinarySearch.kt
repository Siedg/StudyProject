package br.com.studyproject.exercises

class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex
        if (nums.isEmpty()) return -1

        while (left <= right) {
            val mid = (left + right) / 2

            when {
                target == nums[mid] -> return mid
                target > nums[mid] -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return -1
    }
}
