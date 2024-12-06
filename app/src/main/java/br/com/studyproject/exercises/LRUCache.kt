package br.com.studyproject.exercises

class LRUCache(capacity: Int) {

    private val cache: MutableMap<Int, Node> = mutableMapOf()
    private val capacity = capacity
    private val head: Node = Node(-1, -1)
    private val tail: Node = Node(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    data class Node(var key: Int, var value: Int, var prev: Node? = null, var next: Node? = null)

    private fun removeNode(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }

    private fun addNodeToFront(node: Node) {
        node.next = head.next
        node.prev = head
        head.next?.prev = node
        head.next = node
    }

    fun get(key: Int): Int {
        val node = cache[key] ?: return -1
        removeNode(node)
        addNodeToFront(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        val node = cache[key]

        if (node != null) {
            node.value = value
            removeNode(node)
            addNodeToFront(node)
        } else {
            val newNode = Node(key, value)
            cache[key] = newNode
            addNodeToFront(newNode)

            if (cache.size > capacity) {
                val tailNode = tail.prev!!
                cache.remove(tailNode.key)
                removeNode(tailNode)
            }
        }
    }
}
