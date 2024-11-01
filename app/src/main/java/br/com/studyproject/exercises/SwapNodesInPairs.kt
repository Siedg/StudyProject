package br.com.studyproject.exercises

import br.com.studyproject.model.ListNode

class SwapNodesInPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var current = dummy

        while (current.next != null && current.next?.next != null) {
            val first = current.next
            val second = current.next?.next

            first?.next = second?.next
            second?.next = first
            current.next = second

            current = first!!
        }

        return dummy.next
    }
}