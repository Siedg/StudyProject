package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun levelOrder(root: TreeNode?): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    if (root == null) return result

    val queue = ArrayDeque<TreeNode?>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        val currentLevel = mutableListOf<Int>()

        for (i in 0 until levelSize) {
            val currentNode = queue.removeFirst()
            currentLevel.add(currentNode!!.`val`)

            currentNode.left?.let { queue.add(it) }
            currentNode.right?.let { queue.add(it) }
        }

        result.add(currentLevel)
    }

    return result
}
