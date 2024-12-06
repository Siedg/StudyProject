package br.com.studyproject.exercises

import br.com.studyproject.model.ListNode

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head == null || k == 1) return head

    val dummy = ListNode(0).apply { next = head }
    var prevGroupEnd: ListNode? = dummy
    var current: ListNode? = head

    while (current != null) {
        var groupStart = current
        var count = 0

        while (current != null && count < k) {
            current = current.next
            count++
        }

        if (count == k) {
            val (newStart, newEnd) = reverseGroup(groupStart, k)
            prevGroupEnd?.next = newStart
            newEnd?.next = current
            prevGroupEnd = newEnd
        }
    }

    return dummy.next
}

fun reverseGroup(head: ListNode?, k: Int): Pair<ListNode?, ListNode?> {
    var prev: ListNode? = null
    var current = head
    var count = 0

    while (current != null && count < k) {
        val next = current.next
        current.next = prev
        prev = current
        current = next
        count++
    }

    return Pair(prev, head)
}
