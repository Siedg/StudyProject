package br.com.studyproject.exercisesII

/*
Write an algorithm to determine if a number n is a happy number.
A happy number is defined as:
Starting with any positive integer,
Replace the number by the sum of the squares of its digits.
Repeat the process until:
The number equals 1 → happy
Or it loops endlessly → not happy
 */

fun isHappy(n: Int): Boolean {
    if (n <= 0) return false

    val seen = mutableSetOf<Int>()
    var current = n

    while (current != 1) {
        if (current in seen) return false
        seen.add(current)

        current = sumOfSquares(current)
    }

    return true
}

private fun sumOfSquares(num: Int): Int {
    var n = num
    var sum = 0

    while (n > 0) {
        val digit = n % 10
        sum += digit * digit
        n /= 10
    }

    return sum
}

data class HappyNumberTestCase(
    val input: Int,
    val expected: Boolean
)

fun runHappyNumberTests() {

    val testCases = listOf(
        HappyNumberTestCase(1, true),
        HappyNumberTestCase(7, true),
        HappyNumberTestCase(10, true),
        HappyNumberTestCase(19, true),
        HappyNumberTestCase(100, true),
        HappyNumberTestCase(2, false),
        HappyNumberTestCase(3, false),
        HappyNumberTestCase(4, false),
        HappyNumberTestCase(20, false),
        HappyNumberTestCase(0, false),
        HappyNumberTestCase(-1, false),
        HappyNumberTestCase(100000, true),
        HappyNumberTestCase(999999, false)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = isHappy(test.input)

        if (result == test.expected) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Input: ${test.input}")
            println("Expected: ${test.expected}")
            println("Received: $result")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
