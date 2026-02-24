package br.com.studyproject.exercisesII

/*
Dado um array de inteiros, retorne true se existir algum elemento duplicado.
 */

fun containsDuplicate(numbers: IntArray): Boolean {
    val seen = mutableSetOf<Int>()

    for (num in numbers) {
        if (!seen.add(num)) {
            return true
        }
    }

    return false
}

data class DuplicateTestCase(
    val nums: IntArray,
    val expected: Boolean
)

fun runContainsDuplicateTests() {
    val testCases = listOf(
        DuplicateTestCase(intArrayOf(1, 2, 3, 1), true),
        DuplicateTestCase(intArrayOf(1, 2, 3, 4), false),
        DuplicateTestCase(intArrayOf(5, 5), true),
        DuplicateTestCase(intArrayOf(5, 6), false),
        DuplicateTestCase(intArrayOf(-1, -2, -3, -1), true),
        DuplicateTestCase(intArrayOf(-1, -2, -3, -4), false),
        DuplicateTestCase(intArrayOf(0, 1, 2, 0), true),
        DuplicateTestCase(intArrayOf(0), false),
        DuplicateTestCase(intArrayOf(), false),
        DuplicateTestCase((1..10000).toList().toIntArray(), false),
        DuplicateTestCase((1..9999).toList().toIntArray() + 1, true),
        DuplicateTestCase(intArrayOf(7,7,7,7,7), true)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {
        val result = containsDuplicate(test.nums)

        if (result == test.expected) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Array: ${test.nums.contentToString()}")
            println("Expected: ${test.expected}")
            println("Result: $result")
            println()
        }
    }

    println("Final result: $passed/${testCases.size} passed.")
}
