package br.com.studyproject.exercisesII

import br.com.studyproject.model.ListNode

/*
Given the head of a linked list, determine if the list has a cycle in it.
 */

fun hasCycle(head: ListNode?): Boolean {
    if (head == null) return false

    var slow = head
    var fast = head

    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next

        if (slow == fast) {
            return true
        }
    }

    return false
}

fun buildListWithCycle(values: IntArray, pos: Int): ListNode? {
    if (values.isEmpty()) return null

    val head = ListNode(values[0])
    var current = head
    var cycleNode: ListNode? = null

    if (pos == 0) cycleNode = head

    for (i in 1 until values.size) {
        current.next = ListNode(values[i])
        current = current.next!!

        if (i == pos) {
            cycleNode = current
        }
    }

    if (pos >= 0) {
        current.next = cycleNode
    }

    return head
}

data class DetectCycleTestCase(
    val values: IntArray,
    val pos: Int,
    val expected: Boolean
)

fun runDetectCycleTests() {

    val testCases = listOf(
        DetectCycleTestCase(intArrayOf(), -1, false),
        DetectCycleTestCase(intArrayOf(1), -1, false),
        DetectCycleTestCase(intArrayOf(1), 0, true),
        DetectCycleTestCase(intArrayOf(1,2), -1, false),
        DetectCycleTestCase(intArrayOf(1,2), 0, true),
        DetectCycleTestCase(intArrayOf(1,2), 1, true),
        DetectCycleTestCase(intArrayOf(3,2,0,-4), 1, true),
        DetectCycleTestCase(intArrayOf(3,2,0,-4), -1, false),
        DetectCycleTestCase(intArrayOf(1,2,3,4,5), 2, true),
        DetectCycleTestCase(intArrayOf(1,2,3,4,5), -1, false)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val head = buildListWithCycle(test.values, test.pos)
        val result = hasCycle(head)

        if (result == test.expected) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Values: ${test.values.contentToString()}")
            println("Cycle at pos: ${test.pos}")
            println("Expected: ${test.expected}")
            println("Received: $result")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
