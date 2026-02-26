package br.com.studyproject.exercisesII

import androidx.collection.mutableIntListOf

/*
Mova todos os zeros para o final do array mantendo a ordem relativa.
 */

fun moveZeroes(numbers: IntArray): IntArray {
    var index = 0

    for(i in numbers.indices) {
        if (numbers[i] != 0) {
            val aux = numbers[index]
            numbers[index] = numbers[i]
            numbers[i] = aux
            index++
        }
    }
    return numbers
}

data class MoveZeroTestCase(
    val input: IntArray,
    val expected: IntArray
)

fun runMoveZeroTests() {

    val testCases = listOf(

        // 1. Empty
        MoveZeroTestCase(intArrayOf(), intArrayOf()),

        // 2. Single element
        MoveZeroTestCase(intArrayOf(0), intArrayOf(0)),
        MoveZeroTestCase(intArrayOf(5), intArrayOf(5)),

        // 3. All zeros
        MoveZeroTestCase(intArrayOf(0,0,0), intArrayOf(0,0,0)),

        // 4. No zeros
        MoveZeroTestCase(intArrayOf(1,2,3), intArrayOf(1,2,3)),

        // 5. Zeros at start
        MoveZeroTestCase(intArrayOf(0,0,1,2), intArrayOf(1,2,0,0)),

        // 6. Zeros at end
        MoveZeroTestCase(intArrayOf(1,2,0,0), intArrayOf(1,2,0,0)),

        // 7. Zeros in middle
        MoveZeroTestCase(intArrayOf(1,0,2,0,3), intArrayOf(1,2,3,0,0)),

        // 8. Alternating zeros
        MoveZeroTestCase(intArrayOf(0,1,0,2,0,3), intArrayOf(1,2,3,0,0,0)),

        // 9. Negative numbers
        MoveZeroTestCase(intArrayOf(-1,0,-2,0,3), intArrayOf(-1,-2,3,0,0)),

        // 10. Already correct
        MoveZeroTestCase(intArrayOf(4,5,6,0,0), intArrayOf(4,5,6,0,0)),

        // 11. Multiple consecutive zeros
        MoveZeroTestCase(intArrayOf(1,0,0,0,2), intArrayOf(1,2,0,0,0)),

        // 12. Large array
        MoveZeroTestCase(
            (1..1000).toList().toIntArray() + intArrayOf(0,0,0),
            (1..1000).toList().toIntArray() + intArrayOf(0,0,0)
        ),

        // 13. Only one non-zero
        MoveZeroTestCase(intArrayOf(0,0,5,0), intArrayOf(5,0,0,0)),

        // 14. All permutations small space (length 3 exhaustive)
        MoveZeroTestCase(intArrayOf(0,1,2), intArrayOf(1,2,0)),
        MoveZeroTestCase(intArrayOf(2,0,1), intArrayOf(2,1,0)),
        MoveZeroTestCase(intArrayOf(1,2,0), intArrayOf(1,2,0)),
        MoveZeroTestCase(intArrayOf(0,0,1), intArrayOf(1,0,0)),
        MoveZeroTestCase(intArrayOf(1,0,0), intArrayOf(1,0,0))
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val inputCopy = test.input.copyOf()
        moveZeroes(inputCopy)

        if (inputCopy.contentEquals(test.expected)) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Input: ${test.input.contentToString()}")
            println("Expected: ${test.expected.contentToString()}")
            println("Received: ${inputCopy.contentToString()}")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
