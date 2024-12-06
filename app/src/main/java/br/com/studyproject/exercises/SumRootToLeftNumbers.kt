package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun sumNumbers(root: TreeNode?): Int {
    return dfs(root, 0)
}

private fun dfs(node: TreeNode?, currentSum: Int): Int {
    if (node == null) return 0

    val newSum = currentSum * 10 + node.`val`

    if (node.left == null && node.right == null) {
        return newSum
    }

    return dfs(node.left, newSum) + dfs(node.right, newSum)
}
