package br.com.studyproject.exercisesII

import br.com.studyproject.model.ListNode

/*
Given the head of a singly linked list, reverse the list and return its new head.
 */

fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var current = head

    while (current != null) {
        val nextTemp = current.next
        current.next = prev
        prev = current
        current = nextTemp
    }

    return prev
}

fun buildList(values: IntArray): ListNode? {
    if (values.isEmpty()) return null
    val head = ListNode(values[0])
    var current = head
    for (i in 1 until values.size) {
        current.next = ListNode(values[i])
        current = current.next!!
    }
    return head
}

fun reverseListIterative(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var current = head

    while (current != null) {
        val nextTemp = current.next
        current.next = prev
        prev = current
        current = nextTemp
    }

    return prev
}

fun listToArray(head: ListNode?): IntArray {
    val result = mutableListOf<Int>()
    var current = head
    while (current != null) {
        result.add(current.`val`)
        current = current.next
    }
    return result.toIntArray()
}

data class ReverseLinkedListTestCase(
    val input: IntArray,
    val expected: IntArray
)

fun runReverseLinkedListTests() {

    val testCases = listOf(
        ReverseLinkedListTestCase(intArrayOf(), intArrayOf()),
        ReverseLinkedListTestCase(intArrayOf(1), intArrayOf(1)),
        ReverseLinkedListTestCase(intArrayOf(1,2), intArrayOf(2,1)),
        ReverseLinkedListTestCase(intArrayOf(1,2,3,4,5), intArrayOf(5,4,3,2,1)),
        ReverseLinkedListTestCase(intArrayOf(-1,-2,-3), intArrayOf(-3,-2,-1)),
        ReverseLinkedListTestCase(intArrayOf(1,1,1), intArrayOf(1,1,1)),
        ReverseLinkedListTestCase(intArrayOf(10,20,30,40), intArrayOf(40,30,20,10))
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val inputList = buildList(test.input)
        val reversed = reverseList(inputList)
        val resultArray = listToArray(reversed)

        if (resultArray.contentEquals(test.expected)) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Input: ${test.input.contentToString()}")
            println("Expected: ${test.expected.contentToString()}")
            println("Received: ${resultArray.contentToString()}")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
