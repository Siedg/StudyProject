package br.com.studyproject.exercisesII

fun missingNumber(nums: IntArray): Int {
    val n = nums.size
    val expectedSum = n * (n + 1) / 2
    val actualSum = nums.sum()
    return expectedSum - actualSum
}
data class MissingNumberTestCase(
    val input: IntArray,
    val expected: Int
)

fun runMissingNumberTests() {

    val largeArrayMissingMiddle = (0..10000).toMutableList().apply {
        remove(5678)
    }.toIntArray()

    val largeArrayMissingEnd = IntArray(10000) { it }

    val testCases = listOf(
        MissingNumberTestCase(intArrayOf(3,0,1), 2),
        MissingNumberTestCase(intArrayOf(0,1), 2),
        MissingNumberTestCase(intArrayOf(1), 0),
        MissingNumberTestCase(intArrayOf(0), 1),
        MissingNumberTestCase(intArrayOf(2,0), 1),
        MissingNumberTestCase(intArrayOf(9,6,4,2,3,5,7,0,1), 8),
        MissingNumberTestCase(intArrayOf(0,1,2,3,4,5), 6),
        MissingNumberTestCase(intArrayOf(1,2,3,4,5), 0),
        MissingNumberTestCase(largeArrayMissingMiddle, 5678),
        MissingNumberTestCase(largeArrayMissingEnd, 10000),
        MissingNumberTestCase(intArrayOf(), 0)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = missingNumber(test.input)

        if (result == test.expected) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Input (first 10): ${test.input.take(10)}...")
            println("Expected: ${test.expected}")
            println("Received: $result")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
