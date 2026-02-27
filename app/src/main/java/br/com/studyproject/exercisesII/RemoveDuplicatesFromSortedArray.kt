package br.com.studyproject.exercisesII

/*
Given a sorted array nums, remove the duplicates in-place such that each element appears only once and return the new length.

Do not allocate extra space for another array.
Modify the input array in-place.
 */

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var slow = 0

    for (fast in 1 until nums.size) {
        if (nums[fast] != nums[slow]) {
            slow++
            nums[slow] = nums[fast]
        }
    }

    return slow + 1
}

data class RemoveDuplicatesTestCase(
    val input: IntArray,
    val expectedLength: Int,
    val expectedPrefix: IntArray
)

fun runRemoveDuplicatesTests() {

    val testCases = listOf(
        RemoveDuplicatesTestCase(intArrayOf(), 0, intArrayOf()),
        RemoveDuplicatesTestCase(intArrayOf(1), 1, intArrayOf(1)),
        RemoveDuplicatesTestCase(intArrayOf(1,1), 1, intArrayOf(1)),
        RemoveDuplicatesTestCase(intArrayOf(1,2), 2, intArrayOf(1,2)),
        RemoveDuplicatesTestCase(intArrayOf(1,1,1,1), 1, intArrayOf(1)),
        RemoveDuplicatesTestCase(intArrayOf(1,2,3,4), 4, intArrayOf(1,2,3,4)),
        RemoveDuplicatesTestCase(intArrayOf(1,1,2), 2, intArrayOf(1,2)),
        RemoveDuplicatesTestCase(intArrayOf(0,0,1,1,1,2,2,3,3,4), 5, intArrayOf(0,1,2,3,4)),
        RemoveDuplicatesTestCase(intArrayOf(-3,-3,-2,-1,-1,0), 4, intArrayOf(-3,-2,-1,0)),
        RemoveDuplicatesTestCase(intArrayOf(1,1,2,2,3,3,4,4,5), 5, intArrayOf(1,2,3,4,5))
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val numsCopy = test.input.copyOf()
        val k = removeDuplicates(numsCopy)

        val prefixCorrect = numsCopy.take(k).toIntArray().contentEquals(test.expectedPrefix)

        if (k == test.expectedLength && prefixCorrect) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Input: ${test.input.contentToString()}")
            println("Expected Length: ${test.expectedLength}")
            println("Received Length: $k")
            println("Expected Prefix: ${test.expectedPrefix.contentToString()}")
            println("Received Prefix: ${numsCopy.take(k).toIntArray().contentToString()}")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
