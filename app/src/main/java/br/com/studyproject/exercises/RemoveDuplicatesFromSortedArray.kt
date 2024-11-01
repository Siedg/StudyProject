package br.com.studyproject.exercises

class RemoveDuplicatesFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        val uniqueNums = nums.distinct()
        for (i in uniqueNums.indices) {
            nums[i] = uniqueNums[i]
        }
        return uniqueNums.size
    }
}