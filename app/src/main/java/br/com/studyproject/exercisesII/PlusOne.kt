package br.com.studyproject.exercisesII

/*
You are given a large integer represented as an array of digits.
Increment the integer by one and return the resulting array.
 */

fun plusOne(digits: IntArray): IntArray {

    for (i in digits.lastIndex downTo 0) {

        if (digits[i] < 9) {
            digits[i]++
            return digits
        }

        digits[i] = 0
    }

    val result = IntArray(digits.size + 1)
    result[0] = 1
    return result
}

data class PlusOneTestCase(
    val input: IntArray,
    val expected: IntArray
)

fun runPlusOneTests() {

    val testCases = listOf(
        PlusOneTestCase(intArrayOf(1,2,3), intArrayOf(1,2,4)),
        PlusOneTestCase(intArrayOf(4,3,2,1), intArrayOf(4,3,2,2)),
        PlusOneTestCase(intArrayOf(9), intArrayOf(1,0)),
        PlusOneTestCase(intArrayOf(1,9), intArrayOf(2,0)),
        PlusOneTestCase(intArrayOf(9,9), intArrayOf(1,0,0)),
        PlusOneTestCase(intArrayOf(9,9,9), intArrayOf(1,0,0,0)),
        PlusOneTestCase(intArrayOf(0), intArrayOf(1)),
        PlusOneTestCase(intArrayOf(8,9,9,9), intArrayOf(9,0,0,0)),
        PlusOneTestCase(intArrayOf(2,9,9), intArrayOf(3,0,0)),
        PlusOneTestCase(intArrayOf(1,2,9,9), intArrayOf(1,3,0,0))
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = plusOne(test.input.copyOf())

        if (result.contentEquals(test.expected)) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Input: ${test.input.contentToString()}")
            println("Expected: ${test.expected.contentToString()}")
            println("Received: ${result.contentToString()}")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
