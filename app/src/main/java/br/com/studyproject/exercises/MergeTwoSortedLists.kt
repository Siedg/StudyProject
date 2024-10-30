package br.com.studyproject.exercises

import br.com.studyproject.model.ListNode

class MergeTwoSortedLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var current: ListNode? = dummyHead
        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            if (l1.`val` <= l2.`val`) {
                current?.next = l1
                l1 = l1.next
            } else {
                current?.next = l2
                l2 = l2.next
            }
            current = current?.next
        }

        if (l1 != null) current?.next = l1
        if (l2 != null) current?.next = l2

        return dummyHead.next
    }
}