package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun kthSmallest(root: TreeNode?, k: Int): Int {
    var count = 0
    var result = -1

    fun inOrder(node: TreeNode?) {
        if (node == null) return
        inOrder(node.left)
        count++
        if (count == k) {
            result = node.`val`
            return
        }
        inOrder(node.right)
    }

    inOrder(root)

    return result
}
