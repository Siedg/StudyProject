package br.com.studyproject.exercisesII

/*
You are given two sorted integer arrays nums1 and nums2,
and two integers m and n.
Merge nums2 into nums1 as one sorted array.
nums1 has a size of m + n,
where the last n elements are zeros and should be ignored.
 */

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var p1 = m - 1
    var p2 = n - 1
    var p = m + n - 1

    while (p2 >= 0) {
        if (p1 >= 0 && nums1[p1] > nums2[p2]) {
            nums1[p] = nums1[p1]
            p1--
        } else {
            nums1[p] = nums2[p2]
            p2--
        }
        p--
    }
}

data class MergeTestCase(
    val nums1: IntArray,
    val m: Int,
    val nums2: IntArray,
    val n: Int,
    val expected: IntArray
)

fun runMergeTests() {

    val largeNums1 = IntArray(20000)
    for (i in 0 until 10000) {
        largeNums1[i] = i
    }

    val largeNums2 = IntArray(10000) { it + 10000 }
    val largeExpected = IntArray(20000) { it }

    val testCases = listOf(
        MergeTestCase(intArrayOf(1,2,3,0,0,0), 3, intArrayOf(2,5,6), 3, intArrayOf(1,2,2,3,5,6)),
        MergeTestCase(intArrayOf(1,2,3), 3, intArrayOf(), 0, intArrayOf(1,2,3)),
        MergeTestCase(intArrayOf(0), 0, intArrayOf(1), 1, intArrayOf(1)),
        MergeTestCase(intArrayOf(4,5,6,0,0,0), 3, intArrayOf(1,2,3), 3, intArrayOf(1,2,3,4,5,6)),
        MergeTestCase(intArrayOf(1,2,3,0,0,0), 3, intArrayOf(4,5,6), 3, intArrayOf(1,2,3,4,5,6)),
        MergeTestCase(intArrayOf(1,2,2,0,0,0), 3, intArrayOf(2,2,3), 3, intArrayOf(1,2,2,2,2,3)),
        MergeTestCase(intArrayOf(-3,-1,0,0,0), 2, intArrayOf(-2,-2,-1), 3, intArrayOf(-3,-2,-2,-1,-1)),
        MergeTestCase(intArrayOf(2,0), 1, intArrayOf(1), 1, intArrayOf(1,2)),
        MergeTestCase(intArrayOf(1,4,7,0,0,0), 3, intArrayOf(2,3,6), 3, intArrayOf(1,2,3,4,6,7)),
        MergeTestCase(largeNums1.copyOf(), 10000, largeNums2, 10000, largeExpected)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val nums1Copy = test.nums1.copyOf()
        merge(nums1Copy, test.m, test.nums2, test.n)

        if (nums1Copy.contentEquals(test.expected)) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Expected: ${test.expected.take(20)}")
            println("Received: ${nums1Copy.take(20)}")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}