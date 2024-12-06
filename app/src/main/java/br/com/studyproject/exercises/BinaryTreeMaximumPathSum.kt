package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

var maxSum = Int.MIN_VALUE

fun maxPathSum(root: TreeNode?): Int {
    dfs(root)
    return maxSum
}

private fun dfs(node: TreeNode?): Int {
    if (node == null) return 0

    val left = maxOf(dfs(node.left), 0)
    val right = maxOf(dfs(node.right), 0)

    val currentPathSum = node.`val` + left + right
    maxSum = maxOf(maxSum, currentPathSum)

    return node.`val` + maxOf(left, right)
}
