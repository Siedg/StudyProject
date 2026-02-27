package br.com.studyproject.exercisesII

/*
Given a 1-indexed sorted array numbers,
find two numbers such that they add up to a specific target.
 */

fun twoSumII(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.lastIndex

    while (left < right) {
        val sum = numbers[left] + numbers[right]

        when {
            sum == target -> {
                // Retorna índices 1-based
                return intArrayOf(left + 1, right + 1)
            }
            sum < target -> {
                left++
            }
            else -> {
                right--
            }
        }
    }

    // O problema garante que sempre existe solução
    return intArrayOf()
}

data class TwoSumIITestCase(
    val numbers: IntArray,
    val target: Int,
    val expected: IntArray
)

fun runTwoSumIITests() {

    val testCases = listOf(
        TwoSumIITestCase(intArrayOf(2,7,11,15), 9, intArrayOf(1,2)),
        TwoSumIITestCase(intArrayOf(2,3,4), 6, intArrayOf(1,3)),
        TwoSumIITestCase(intArrayOf(-1,0), -1, intArrayOf(1,2)),
        TwoSumIITestCase(intArrayOf(-3,-1,0,2,4), 1, intArrayOf(1,5)),
        TwoSumIITestCase(intArrayOf(1,2,3,4,4,9), 8, intArrayOf(4,5)),
        TwoSumIITestCase(intArrayOf(1,5,6,10), 11, intArrayOf(1,4)),
        TwoSumIITestCase(intArrayOf(1,2,3,4,5,6), 11, intArrayOf(5,6)),
        TwoSumIITestCase(intArrayOf(-10,-3,1,5,9), -13, intArrayOf(1,2)),
        TwoSumIITestCase(intArrayOf(1,3,4,5,7,10,11), 9, intArrayOf(3,4)),
        TwoSumIITestCase(intArrayOf(5,25,75), 100, intArrayOf(2,3))
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = twoSumII(test.numbers.copyOf(), test.target)

        if (result.contentEquals(test.expected)) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Numbers: ${test.numbers.contentToString()}")
            println("Target: ${test.target}")
            println("Expected: ${test.expected.contentToString()}")
            println("Received: ${result.contentToString()}")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
