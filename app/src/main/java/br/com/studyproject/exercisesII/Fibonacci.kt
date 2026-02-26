package br.com.studyproject.exercisesII

/*
Implement a function that returns the n-th Fibonacci number.
Assume the classic definition:
F(0) = 0
F(1) = 1
F(n) = F(n-1) + F(n-2)
 */

fun fibonacci(n: Int): Int {
    if (n < 0) return -1

    val memo = IntArray(n + 1) { -1 }

    fun fib(i: Int): Int {
        if (i == 0) return 0
        if (i == 1) return 1

        if (memo[i] != -1) return memo[i]

        memo[i] = fib(i - 1) + fib(i - 2)
        return memo[i]
    }

    return fib(n)
}

fun fibonacciIterative(n: Int): Int {
    if (n < 0) return -1
    if (n == 0) return 0
    if (n == 1) return 1

    var prev2 = 0  // F(0)
    var prev1 = 1  // F(1)

    for (i in 2..n) {
        val current = prev1 + prev2
        prev2 = prev1
        prev1 = current
    }

    return prev1
}

data class FibonacciTestCase(
    val input: Int,
    val expected: Int?
)

fun runFibonacciTests() {

    val testCases = listOf(
        FibonacciTestCase(0, 0),
        FibonacciTestCase(1, 1),
        FibonacciTestCase(2, 1),
        FibonacciTestCase(3, 2),
        FibonacciTestCase(4, 3),
        FibonacciTestCase(5, 5),
        FibonacciTestCase(6, 8),
        FibonacciTestCase(7, 13),
        FibonacciTestCase(10, 55),
        FibonacciTestCase(15, 610),
        FibonacciTestCase(20, 6765),
        FibonacciTestCase(30, 832040),
        FibonacciTestCase(40, 102334155),
        FibonacciTestCase(45, 1134903170),
        FibonacciTestCase(0, 0),
        FibonacciTestCase(1, 1),
        FibonacciTestCase(2, 1),
        FibonacciTestCase(3, 2),
        FibonacciTestCase(5, 5),
        FibonacciTestCase(10, 55),
        FibonacciTestCase(30, 832040),
        FibonacciTestCase(-1, -1)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = fibonacciIterative(test.input)

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