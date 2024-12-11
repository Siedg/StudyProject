package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun averageOfLevels(root: TreeNode?): List<Double> {
    val result = mutableListOf<Double>()
    if (root == null) return result

    val queue = ArrayDeque<TreeNode?>()
    queue.add(root)

    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        var levelSum = 0.0

        for (i in 0 until levelSize) {
            val currentNode = queue.removeFirst()
            levelSum += currentNode!!.`val`

            currentNode?.left?.let { queue.add(it) }
            currentNode?.right?.let { queue.add(it) }
        }

        result.add(levelSum / levelSize)
    }

    return result
}
