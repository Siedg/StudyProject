package br.com.studyproject.exercisesII

/*
Dadas duas strings s e t, retorne true se t for um anagrama de s.
 */

fun validAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val count = IntArray(26)

    for (i in s.indices) {
        count[s[i] - 'a']++
        count[t[i] - 'a']--
    }

    for (value in count) {
        if (value != 0) return false
    }

    return true
}

data class AnagramTestCase(
    val s: String,
    val t: String,
    val expected: Boolean
)

fun runValidAnagramTests() {

    val testCases = listOf(

        // Basic valid cases
        AnagramTestCase("anagram", "nagaram", true),
        AnagramTestCase("abc", "abc", true),
        AnagramTestCase("aabbcc", "ccbbaa", true),

        // Basic invalid cases
        AnagramTestCase("rat", "car", false),
        AnagramTestCase("aabb", "aaab", false),

        // Length mismatch (BUG case from your version)
        AnagramTestCase("abc", "abcc", false),
        AnagramTestCase("abcd", "abc", false),

        // Empty strings
        AnagramTestCase("", "", true),
        AnagramTestCase("", "a", false),

        // Single character
        AnagramTestCase("a", "a", true),
        AnagramTestCase("a", "b", false),

        // Large valid case
        AnagramTestCase(
            "abcdefghijklmnopqrstuvwxyz",
            "zyxwvutsrqponmlkjihgfedcba",
            true
        ),

        // Large invalid case
        AnagramTestCase(
            "abcdefghijklmnopqrstuvwxyz",
            "abcdefghijklmnopqrstuvwxyy",
            false
        ),

        // Repeated characters mismatch
        AnagramTestCase("aaa", "aa", false),
        AnagramTestCase("aa", "aaa", false),

        // Same prefix but extra char (critical edge case)
        AnagramTestCase("abc", "abcd", false)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {
        val result = validAnagram(test.s, test.t)

        if (result == test.expected) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Input: s='${test.s}', t='${test.t}'")
            println("Expected: ${test.expected}")
            println("Received: $result")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}