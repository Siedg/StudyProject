package br.com.studyproject.exercises

import br.com.studyproject.model.ListNode

fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    if (head == null || left == right) return head

    val dummy = ListNode(0).apply { next = head }
    var prev: ListNode? = dummy

    for (i in 1 until left) {
        prev = prev?.next
    }

    val start = prev?.next
    var then = start?.next

    for (i in 0 until right - left) {
        start?.next = then?.next
        then?.next = prev?.next
        prev?.next = then
        then = start?.next
    }

    return dummy.next
}
