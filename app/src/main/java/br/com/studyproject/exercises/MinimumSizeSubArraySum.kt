package br.com.studyproject.exercises

fun minSubArrayLenOn(target: Int, nums: IntArray): Int {
    var start = 0
    var sum = 0
    var minLength = Int.MAX_VALUE

    for (end in nums.indices) {
        sum += nums[end]

        while (sum >= target) {
            minLength = minOf(minLength, end - start + 1)
            sum -= nums[start]
            start++
        }
    }

    return if (minLength == Int.MAX_VALUE) 0 else minLength
}

fun minSubArrayLenOnlogn(target: Int, nums: IntArray): Int {
    val n = nums.size
    val prefixSums = IntArray(n + 1)

    for (i in nums.indices) {
        prefixSums[i + 1] = prefixSums[i] + nums[i]
    }

    var minLength = Int.MAX_VALUE

    for (i in 0 until n) {
        val requiredSum = target + prefixSums[i]
        val bound = prefixSums.binarySearch(requiredSum)

        val j = if (bound >= 0) bound else -(bound + 1)

        if (j <= n) {
            minLength = minOf(minLength, j - i)
        }
    }

    return if (minLength == Int.MAX_VALUE) 0 else minLength
}
