package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode
import java.util.LinkedList
import java.util.Queue

fun printTree(root: TreeNode?): Array<Array<String>> {
    if (root == null) return arrayOf()

    val height = getHeight(root)
    val n = (1 shl (height + 1)) - 1
    val m = height + 1
    val res = Array(m) { Array(n) { "" } }

    val queue: Queue<Triple<TreeNode, Int, Int>> = LinkedList()
    queue.add(Triple(root, 0, (n - 1) / 2))

    while (queue.isNotEmpty()) {
        val (node, row, col) = queue.poll()

        res[row][col] = node.`val`.toString()

        if (node.left != null) {
            queue.add(Triple(node.left!!, row + 1, col - (1 shl (height - row - 1))))
        }
        if (node.right != null) {
            queue.add(Triple(node.right!!, row + 1, col + (1 shl (height - row - 1))))
        }
    }

    return res
}

fun getHeight(node: TreeNode?): Int {
    if (node == null) return -1
    return 1 + maxOf(getHeight(node.left), getHeight(node.right))
}
