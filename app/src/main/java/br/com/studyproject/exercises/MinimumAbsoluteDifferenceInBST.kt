package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun getMinimumDifference(root: TreeNode?): Int {
    val inOrderValues = mutableListOf<Int>()

    fun inOrder(node: TreeNode?) {
        if (node == null) return
        inOrder(node.left)
        inOrderValues.add(node.`val`)
        inOrder(node.right)
    }

    inOrder(root)

    var minDiff = Int.MAX_VALUE
    for (i in 1 until inOrderValues.size) {
        minDiff = minOf(minDiff, inOrderValues[i] - inOrderValues[i - 1])
    }

    return minDiff
}
