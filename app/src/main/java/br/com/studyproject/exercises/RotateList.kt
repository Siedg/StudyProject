package br.com.studyproject.exercises

import br.com.studyproject.model.ListNode

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 0) return head

    var length = 1
    var tail = head
    while (tail?.next != null) {
        tail = tail.next
        length++
    }

    val rotateSteps = k % length
    if (rotateSteps == 0) return head

    tail?.next = head

    var newTail = head
    for (i in 1 until length - rotateSteps) {
        newTail = newTail?.next
    }

    val newHead = newTail?.next
    newTail?.next = null

    return newHead
}
