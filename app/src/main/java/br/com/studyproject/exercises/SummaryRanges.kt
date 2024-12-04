package br.com.studyproject.exercises

fun summaryRanges(nums: IntArray): List<String> {
    val result = mutableListOf<String>()
    if (nums.isEmpty()) return result

    var start = nums[0]

    for (i in 1 until nums.size) {
        if (nums[i] != nums[i - 1] + 1) {
            if (start == nums[i - 1]) {
                result.add("$start")
            } else {
                result.add("$start->${nums[i - 1]}")
            }
            start = nums[i]
        }
    }

    // Add the last range
    if (start == nums[nums.size - 1]) {
        result.add("$start")
    } else {
        result.add("$start->${nums[nums.size - 1]}")
    }

    return result
}
