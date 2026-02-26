package br.com.studyproject.exercisesII

/*
Write a function that reverses a string in-place.
The input is given as a character array.
 */

fun reverseString(s: CharArray) {
    if (s.isEmpty()) return
    var left = 0
    var right = s.lastIndex

    while (left < right) {
        val aux = s[left]
        s[left] = s[right]
        s[right] = aux

        left++
        right--
    }
}

data class ReverseStringTestCase(
    val input: CharArray,
    val expected: CharArray
)

fun runReverseStringTests() {

    val largeInput = CharArray(10000) { ('a' + (it % 26)) }
    val largeExpected = largeInput.copyOf().also { it.reverse() }

    val testCases = listOf(
        ReverseStringTestCase("hello".toCharArray(), "olleh".toCharArray()),
        ReverseStringTestCase("abcd".toCharArray(), "dcba".toCharArray()),
        ReverseStringTestCase("".toCharArray(), "".toCharArray()),
        ReverseStringTestCase("a".toCharArray(), "a".toCharArray()),
        ReverseStringTestCase("abc".toCharArray(), "cba".toCharArray()),
        ReverseStringTestCase("madam".toCharArray(), "madam".toCharArray()),
        ReverseStringTestCase("aaaa".toCharArray(), "aaaa".toCharArray()),
        ReverseStringTestCase("A1b2".toCharArray(), "2b1A".toCharArray()),
        ReverseStringTestCase("a b c".toCharArray(), "c b a".toCharArray()),
        ReverseStringTestCase("!@#$$#@!".toCharArray(), "!@#$$#@!".toCharArray()),
        ReverseStringTestCase(largeInput, largeExpected)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val inputCopy = test.input.copyOf()
        reverseString(inputCopy)

        if (inputCopy.contentEquals(test.expected)) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Expected: ${test.expected.concatToString().take(50)}")
            println("Received: ${inputCopy.concatToString().take(50)}")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
