package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun countNodes(root: TreeNode?): Int {
    if (root == null) return 0

    var leftHeight = thisGetHeight(root.left)
    var rightHeight = thisGetHeight(root.right)

    if (leftHeight == rightHeight) {
        return (1 shl leftHeight) + countNodes(root.right)
    } else {
        return (1 shl rightHeight) + countNodes(root.left)
    }
}

private fun thisGetHeight(node: TreeNode?): Int {
    var height = 0
    var currentNode = node
    while (currentNode != null) {
        height++
        currentNode = currentNode.left
    }
    return height
}
