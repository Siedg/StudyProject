package br.com.studyproject.model

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun toListNode(nestedList: List<List<Int>>): ListNode? {
    var head: ListNode? = null
    var current: ListNode? = null

    for (subList in nestedList) {
        for (value in subList) {
            val newNode = ListNode(value)
            if (head == null) {
                head = newNode
                current = head
            } else {
                current?.next = newNode
                current = newNode
            }
        }
    }

    return head
}

fun toArrayListOfListNode(nestedList: List<List<Int>>): Array<ListNode?> {
    val result = ArrayList<ListNode?>()

    for (subList in nestedList) {
        var head: ListNode? = null
        var current: ListNode? = null

        for (value in subList) {
            val newNode = ListNode(value)
            if (head == null) {
                head = newNode
                current = head
            } else {
                current?.next = newNode
                current = newNode
            }
        }

        result.add(head)
    }

    return result.toTypedArray()
}

fun printNodeList(nodeList: List<ListNode?>) {
    for (node in nodeList) {
        var current = node
        while (current != null) {
            print("${current.`val`} -> ")
            current = current.next
        }
        println("null")
    }
}

fun printListNode(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println("null")
}

fun listNodeToList(head: ListNode?): List<Int> {
    val result = mutableListOf<Int>()
    var current = head
    while (current != null) {
        result.add(current.`val`)
        current = current.next
    }
    return result
}

fun listToListNode(list: List<Int>): ListNode? {
    val dummyHead = ListNode(0)
    var current = dummyHead
    for (value in list) {
        current.next = ListNode(value)
        current = current.next!!
    }
    return dummyHead.next
}
