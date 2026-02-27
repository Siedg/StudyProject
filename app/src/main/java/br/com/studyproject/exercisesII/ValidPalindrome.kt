package br.com.studyproject.exercisesII

/*
Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 */

fun isPalindrome(s: String): Boolean {
    var left = 0
    var right = s.lastIndex

    while (left < right) {
        if (!s[left].isLetterOrDigit()) {
            left++
            continue
        } else if (!s[right].isLetterOrDigit()) {
            right--
            continue
        } else if (!s[left].equals(s[right], ignoreCase = true)) return false
        left++
        right--
    }

    return true
}

data class ValidPalindromeTestCase(
    val input: String,
    val expected: Boolean
)

fun runValidPalindromeTests() {

    val testCases = listOf(
        ValidPalindromeTestCase("", true),
        ValidPalindromeTestCase("a", true),
        ValidPalindromeTestCase("aa", true),
        ValidPalindromeTestCase("ab", false),
        ValidPalindromeTestCase("A man, a plan, a canal: Panama", true),
        ValidPalindromeTestCase("race a car", false),
        ValidPalindromeTestCase("0P", false),
        ValidPalindromeTestCase(".,,", true),
        ValidPalindromeTestCase("Able was I ere I saw Elba", true),
        ValidPalindromeTestCase("No lemon, no melon", true),
        ValidPalindromeTestCase("12321", true),
        ValidPalindromeTestCase("1231", false),
        ValidPalindromeTestCase("Madam", true),
        ValidPalindromeTestCase("Was it a car or a cat I saw?", true)
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
