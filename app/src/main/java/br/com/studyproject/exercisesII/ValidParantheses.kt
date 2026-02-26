package br.com.studyproject.exercisesII

/*
Given a string containing only the characters ()[]{},
return true if the input string is valid.
A string is valid if:
Open brackets are closed by the same type.
Open brackets are closed in the correct order.
Every closing bracket has a matching open bracket.
 */

fun isValidParentheses(s: String): Boolean {
    if (s.isEmpty()) return true
    val map = mapOf(')' to '(', ']' to '[', '}' to '{')
    val stack = mutableListOf<Char>()

    for (char in s) {
        if (map.values.contains(char)) {
            stack.add(char)
        } else if (map.containsKey(char)) {
            if (stack.isEmpty()) return false

            if (stack.last() != map[char]) return false

            stack.removeLast()
        } else {
            return false
        }
    }

    return stack.isEmpty()
}

data class ParenthesesTestCase(
    val input: String,
    val expected: Boolean
)

fun runValidParenthesesTests() {

    val testCases = listOf(
        ParenthesesTestCase("()", true),
        ParenthesesTestCase("[]", true),
        ParenthesesTestCase("{}", true),
        ParenthesesTestCase("()[]{}", true),
        ParenthesesTestCase("{[]}", true),
        ParenthesesTestCase("([{}])", true),
        ParenthesesTestCase("((()))", true),
        ParenthesesTestCase("(]", false),
        ParenthesesTestCase("([)]", false),
        ParenthesesTestCase("{[}]", false),
        ParenthesesTestCase("(", false),
        ParenthesesTestCase(")", false),
        ParenthesesTestCase("(((", false),
        ParenthesesTestCase("(()", false),
        ParenthesesTestCase("())", false),
        ParenthesesTestCase("({[)]}", false),
        ParenthesesTestCase("((())", false),
        ParenthesesTestCase("]", false),
        ParenthesesTestCase("}{", false),
        ParenthesesTestCase("", true),
        ParenthesesTestCase("((((((((()))))))))", true),
        ParenthesesTestCase("((((((((())))))))", false)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = isValidParentheses(test.input)

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