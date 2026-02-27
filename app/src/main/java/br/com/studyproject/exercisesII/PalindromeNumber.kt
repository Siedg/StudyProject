package br.com.studyproject.exercisesII

/*
Given an integer x, return true if x is a palindrome, and false otherwise.
 */

fun isPalindrome(x: Int): Boolean {
    if (x < 0) return false

    val s = x.toString()
    var left = 0
    var right = s.lastIndex

    while (left < right) {
        if (s[left] != s[right]) return false
        left++
        right--
    }
    return true
}

fun isPalindromeOptimized(x: Int): Boolean {
    if (x < 0) return false

    val s = x.toString()

    for (i in 0 until s.length / 2) {
        if (s[i] != s[s.lastIndex - i]) return false
    }

    return true
}

fun isPalindromeWithoutConvertingToString(x: Int): Boolean {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false

    var original = x
    var reversedHalf = 0

    while (original > reversedHalf) {
        reversedHalf = reversedHalf * 10 + original % 10
        original /= 10
    }

    return original == reversedHalf || original == reversedHalf / 10
}

data class PalindromeTestCase(
    val input: Int,
    val expected: Boolean
)

fun runPalindromeTests() {

    val testCases = listOf(
        PalindromeTestCase(121, true),
        PalindromeTestCase(-121, false),
        PalindromeTestCase(10, false),
        PalindromeTestCase(0, true),
        PalindromeTestCase(1, true),
        PalindromeTestCase(22, true),
        PalindromeTestCase(12321, true),
        PalindromeTestCase(123321, true),
        PalindromeTestCase(1001, true),
        PalindromeTestCase(1000021, false),
        PalindromeTestCase(2147447412, true),
        PalindromeTestCase(2147483647, false),
        PalindromeTestCase(100, false),
        PalindromeTestCase(11, true),
        PalindromeTestCase(12, false)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = isPalindrome(test.input)

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
