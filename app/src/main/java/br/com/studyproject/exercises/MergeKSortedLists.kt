package br.com.studyproject.exercises

import br.com.studyproject.model.ListNode

class MergeKSortedLists {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val dummyHead = ListNode(0)
        var current: ListNode? = dummyHead
        val numberList: MutableList<Int> = mutableListOf()

        for (l in lists) {
            var currNode = l
            while (currNode != null) {
                numberList.add(currNode.`val`)
                currNode = currNode.next
            }
        }

        numberList.sort()

        numberList.forEach { value ->
            current?.next = ListNode(value)
            current = current?.next
        }
        return dummyHead.next
    }
}