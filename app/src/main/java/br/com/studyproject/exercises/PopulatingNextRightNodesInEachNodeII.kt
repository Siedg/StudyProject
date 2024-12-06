package br.com.studyproject.exercises

import br.com.studyproject.model.Node
import java.util.LinkedList
import java.util.Queue

fun connect(root: Node?): Node? {
    if (root == null) return null

    val queue: Queue<Node> = LinkedList()
    queue.offer(root)

    while (queue.isNotEmpty()) {
        val size = queue.size

        for (i in 0 until size) {
            val node = queue.poll()

            if (i < size - 1) {
                node.next = queue.peek()
            }

            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
        }
    }

    return root
}
