package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun rightSideView(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()
    if (root == null) return result

    val queue = ArrayDeque<TreeNode?>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        var rightMostNode = 0

        for (i in 0 until levelSize) {
            val currentNode = queue.removeFirst()

            if (i == levelSize - 1) {
                rightMostNode = currentNode!!.`val`
            }

            currentNode?.left?.let { queue.add(it) }
            currentNode?.right?.let { queue.add(it) }
        }

        result.add(rightMostNode)
    }

    return result
}
