package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) return false
    if (root.left == null && root.right == null) return root.`val` == targetSum

    val remainingSum = targetSum - root.`val`
    return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum)
}

