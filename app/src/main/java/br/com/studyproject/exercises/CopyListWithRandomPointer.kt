package br.com.studyproject.exercises

import br.com.studyproject.model.NodeRandom

fun copyRandomList(head: NodeRandom?): NodeRandom? {
    if (head == null) return null

    val map = mutableMapOf<NodeRandom, NodeRandom>()

    var current = head
    while (current != null) {
        map[current] = NodeRandom(current.`val`)
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
