package br.com.studyproject.exercisesII

/*
Dado um array nums e um inteiro target, retorne os índices de dois números cuja soma seja igual a target.
 */
fun twoSum(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = 1

    if (numbers.isEmpty()) return intArrayOf(-1, -1)

    while (left < numbers.size - 1) {
        val sum = numbers[left] + numbers[right]
        if (sum == target) return intArrayOf(left, right)
        right++
        if (right >= numbers.size) {
            left++
            right = left + 1
        }
    }
    return intArrayOf(-1, -1)
}

fun twoSumOptimized(numbers: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for (i in numbers.indices) {
        val complement = target - numbers[i]

        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }

        map[numbers[i]] = i
    }

    return intArrayOf(-1, -1)
}

data class TwoSumTestCase(
    val nums: IntArray,
    val target: Int
)

fun isValidTwoSum(nums: IntArray, target: Int, result: IntArray): Boolean {
    if (result.size != 2) return false

    val i = result[0]
    val j = result[1]

    if (i == j) return false
    if (i !in nums.indices || j !in nums.indices) return false

    return nums[i] + nums[j] == target
}

fun runTwoSumTests() {
    val twoSumTestCases = listOf(
        TwoSumTestCase(intArrayOf(2, 7, 11, 15), 9),
        TwoSumTestCase(intArrayOf(3, 2, 4), 6),
        TwoSumTestCase(intArrayOf(3, 3), 6),
        TwoSumTestCase(intArrayOf(-3, 4, 3, 90), 0),
        TwoSumTestCase(intArrayOf(-1, -2, -3, -4, -5), -8),
        TwoSumTestCase(intArrayOf(0, 4, 3, 0), 0),
        TwoSumTestCase(intArrayOf(1, 5, 1, 5), 10),
        TwoSumTestCase(intArrayOf(1, 2, 3, 2), 4),
        TwoSumTestCase(intArrayOf(5, 75, 25), 30),
        TwoSumTestCase(intArrayOf(4, 4, 4), 8)
    )

    var passed = 0

    for ((index, test) in twoSumTestCases.withIndex()) {
        val result = twoSum(test.nums, test.target)

        if (isValidTwoSum(test.nums, test.target, result)) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Array: ${test.nums.contentToString()}")
            println("Expected: ${test.target}")
            println("Result: ${result.contentToString()}")
            println()
        }
    }

    println("Final result: $passed/${twoSumTestCases.size} passed.")
}