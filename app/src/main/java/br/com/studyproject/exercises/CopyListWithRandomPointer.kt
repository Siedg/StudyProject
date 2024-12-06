package br.com.studyproject.exercises

import br.com.studyproject.model.Node

fun copyRandomList(head: Node?): Node? {
    if (head == null) return null

    val map = mutableMapOf<Node, Node>()

    var current = head
    while (current != null) {
        map[current] = Node(current.`val`)
        current = current.next
    }

    current = head
    while (current != null) {
        val newNode = map[current]!!
        newNode.next = map[current.next]
        newNode.random = map[current.random]
        current = current.next
    }

    return map[head]
}
