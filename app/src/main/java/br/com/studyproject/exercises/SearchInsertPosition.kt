package br.com.studyproject.exercises

class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {
        for (i in nums.indices) {
            if (nums[i] >= target) return i
        }
        if (nums.isNotEmpty()) return nums.size
        return 0
    }
}