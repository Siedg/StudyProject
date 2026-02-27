package br.com.studyproject.exercisesII

/*
Given an integer array nums, return the pivot index.
 */

fun pivotIndex(nums: IntArray): Int {
    val totalSum = nums.sum()
    var leftSum = 0

    for (i in nums.indices) {

        val rightSum = totalSum - leftSum - nums[i]

        if (leftSum == rightSum) {
            return i
        }

        leftSum += nums[i]
    }

    return -1
}

data class PivotIndexTestCase(
    val input: IntArray,
    val expected: Int
)

fun runPivotIndexTests() {

    val testCases = listOf(
        PivotIndexTestCase(intArrayOf(), -1),
        PivotIndexTestCase(intArrayOf(1), 0),
        PivotIndexTestCase(intArrayOf(1,7,3,6,5,6), 3),
        PivotIndexTestCase(intArrayOf(1,2,3), -1),
        PivotIndexTestCase(intArrayOf(2,1,-1), 0),
        PivotIndexTestCase(intArrayOf(-1,-1,-1,-1,-1,0), 2),
        PivotIndexTestCase(intArrayOf(0,0,0,0), 0),
        PivotIndexTestCase(intArrayOf(1,-1,0), 2),
        PivotIndexTestCase(intArrayOf(1,2,1), 1),
        PivotIndexTestCase(intArrayOf(10,-10,10,-10,10), 0)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = pivotIndex(test.input.copyOf())

        if (result == test.expected) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Input: ${test.input.contentToString()}")
            println("Expected: ${test.expected}")
            println("Received: $result")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}