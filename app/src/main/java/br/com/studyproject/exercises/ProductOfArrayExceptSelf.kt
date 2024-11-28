package br.com.studyproject.exercises

fun productExceptSelf(nums: IntArray): IntArray {
    var maxValue = 1
    var zeroCount = 0

    nums.forEach {
        if (it != 0) maxValue *= it
        else zeroCount++
    }

    for (i in 0..nums.lastIndex) {
        if (
            zeroCount == 1 && nums[i] != 0 ||
            zeroCount > 1
        ) nums[i] = 0
        else if (nums[i] != 0) nums[i] = maxValue / nums[i]
        else nums[i] = maxValue
    }

    return nums
}
