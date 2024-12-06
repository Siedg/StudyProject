package br.com.studyproject.exercises

import br.com.studyproject.model.ListNode

fun deleteDuplicates(head: ListNode?): ListNode? {
    val dummy = ListNode(0).apply { next = head }
    var prev: ListNode? = dummy
    var current = head

    while (current != null) {
        if (current.next != null && current.`val` == current.next!!.`val`) {
            while (current.next != null && current.`val` == current.next!!.`val`) {
                current = current.next
            }
            prev?.next = current.next
        } else {
            prev = prev?.next
        }
        current = current.next
    }

    return dummy.next
}
