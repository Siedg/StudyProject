package br.com.studyproject.exercises

import br.com.studyproject.model.ListNode

class RemoveNthNodeFromEndOfList {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var count = 1
        var size = 1
        var prevNode = ListNode(0)
        var currNode = head ?: return null
        var nextNode = head

        while (nextNode?.next != null) {
            size++
            nextNode = nextNode?.next
        }

        if (size == n) return head.next

        while (count <= size) {
            if (count == size - n) {
                prevNode = currNode
            }
            if (count == size - n + 1) {
                prevNode.next = currNode.next
                return head
            }

            currNode = currNode.next ?: return null
            count++
        }
        return head
    }
}