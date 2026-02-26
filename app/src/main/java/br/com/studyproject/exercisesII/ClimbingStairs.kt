package br.com.studyproject.exercisesII

/*
You are climbing a staircase with n steps.
Each time you can climb 1 or 2 steps.
Return the number of distinct ways to reach the top.
 */

fun climbStairs(n: Int): Int {
    var prev1 = 0
    var prev2 = 1

    for (i in 2..n) {
        val current = prev1 + prev2
        prev1 = prev2
        prev2 = current
    }

    return prev2
}

data class ClimbingStairsTestCase(
    val input: Int,
    val expected: Int,
    val shouldThrow: Boolean = false
)

fun runClimbingStairsTests() {

    val testCases = listOf(
        ClimbingStairsTestCase(0, 1),
        ClimbingStairsTestCase(1, 1),
        ClimbingStairsTestCase(2, 2),
        ClimbingStairsTestCase(3, 3),
        ClimbingStairsTestCase(4, 5),
        ClimbingStairsTestCase(5, 8),
        ClimbingStairsTestCase(6, 13),
        ClimbingStairsTestCase(7, 21),
        ClimbingStairsTestCase(10, 89),
        ClimbingStairsTestCase(15, 987),
        ClimbingStairsTestCase(20, 10946),
        ClimbingStairsTestCase(30, 1346269),
        ClimbingStairsTestCase(40, 165580141),
        ClimbingStairsTestCase(45, 1836311903),
        ClimbingStairsTestCase(-1, 0, shouldThrow = true)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {
        try {
            val result = climbStairs(test.input)

            if (test.shouldThrow) {
                println("Test ${index + 1} ❌ FAILED (Expected exception)")
            } else if (result == test.expected) {
                println("Test ${index + 1} ✅ PASSED")
                passed++
            } else {
                println("Test ${index + 1} ❌ FAILED")
                println("Input: ${test.input}")
                println("Expected: ${test.expected}")
                println("Received: $result")
                println()
            }

        } catch (e: Exception) {
            if (test.shouldThrow) {
                println("Test ${index + 1} ✅ PASSED (Exception caught)")
                passed++
            } else {
                println("Test ${index + 1} ❌ FAILED (Unexpected exception)")
            }
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
