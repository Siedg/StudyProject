package br.com.studyproject.exercises

import br.com.studyproject.model.ListNode
import br.com.studyproject.model.TreeNode

fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) return null

    val mid = findMiddle(head)

    val root = mid?.`val`?.let { TreeNode(it) }

    if (head == mid) return root

    root?.left = sortedListToBST(head)
    root?.right = sortedListToBST(mid?.next)

    return root
}

fun findMiddle(head: ListNode?): ListNode? {
    var slow = head
    var fast = head
    var prev: ListNode? = null

    while (fast?.next != null) {
        prev = slow
        slow = slow?.next
        fast = fast.next?.next
    }

    prev?.next = null
    return slow
}
