package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun maxDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val leftDepth = maxDepth(root.left)
    val rightDepth = maxDepth(root.right)
    return 1 + maxOf(leftDepth, rightDepth)
}
