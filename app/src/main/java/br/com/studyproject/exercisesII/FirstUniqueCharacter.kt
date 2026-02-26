package br.com.studyproject.exercisesII

/*
Given a string s, return the index of the first non-repeating character.
If it does not exist, return -1.
 */

fun firstUniqChar(s: String): Int {
    val seen = hashMapOf<Char, Int>()

    for (c in s) {
        seen[c] = seen.getOrDefault(c, 0) + 1
    }

    for (i in s.indices) {
        if (seen[s[i]] == 1) return i
    }

    return -1
}

data class FirstUniqueCharTestCase(
    val input: String,
    val expected: Int
)

fun runFirstUniqueCharTests() {

    val largeString = buildString {
        repeat(9999) { append('a') }
        append('b')
    }

    val testCases = listOf(
        FirstUniqueCharTestCase("leetcode", 0),
        FirstUniqueCharTestCase("loveleetcode", 2),
        FirstUniqueCharTestCase("aabbc", 4),
        FirstUniqueCharTestCase("aabccdeff", 2),
        FirstUniqueCharTestCase("aabbcc", -1),
        FirstUniqueCharTestCase("aaaa", -1),
        FirstUniqueCharTestCase("", -1),
        FirstUniqueCharTestCase("z", 0),
        FirstUniqueCharTestCase("aA", 0),
        FirstUniqueCharTestCase("aabb!!c", 6),
        FirstUniqueCharTestCase(largeString, 9999)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = firstUniqChar(test.input)

        if (result == test.expected) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Input: ${test.input.take(50)}")
            println("Expected: ${test.expected}")
            println("Received: $result")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
