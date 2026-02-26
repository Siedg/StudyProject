package br.com.studyproject.exercisesII

import androidx.collection.mutableIntListOf

/*
Given two integer arrays nums1 and nums2,
return an array of their intersection.
Each element in the result must be unique,
and the result can be returned in any order.
 */

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val set1 = nums1.toSet()
    val result = mutableSetOf<Int>()

    for (num in nums2) {
        if (num in set1) {
            result.add(num)
        }
    }

    return result.toIntArray()
}

data class IntersectionTestCase(
    val nums1: IntArray,
    val nums2: IntArray,
    val expected: Set<Int>
)

fun runIntersectionTests() {

    val largeNums1 = IntArray(10000) { it }
    val largeNums2 = IntArray(10000) { it + 5000 }

    val largeExpected = (5000 until 10000).toSet()

    val testCases = listOf(
        IntersectionTestCase(intArrayOf(1,2,2,1), intArrayOf(2,2), setOf(2)),
        IntersectionTestCase(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4), setOf(4,9)),
        IntersectionTestCase(intArrayOf(1,2,3), intArrayOf(4,5,6), emptySet()),
        IntersectionTestCase(intArrayOf(), intArrayOf(1,2,3), emptySet()),
        IntersectionTestCase(intArrayOf(), intArrayOf(), emptySet()),
        IntersectionTestCase(intArrayOf(1,1,1), intArrayOf(1,1), setOf(1)),
        IntersectionTestCase(intArrayOf(-1,-2,-3), intArrayOf(-3,-4,-5), setOf(-3)),
        IntersectionTestCase(intArrayOf(1,2,3,4), intArrayOf(2,3), setOf(2,3)),
        IntersectionTestCase(largeNums1, largeNums2, largeExpected),
        IntersectionTestCase(intArrayOf(1,2,2,3,3,3,4), intArrayOf(2,2,3,5), setOf(2,3))
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = intersection(test.nums1, test.nums2).toSet()

        if (result == test.expected) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Expected: ${test.expected}")
            println("Received: $result")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
