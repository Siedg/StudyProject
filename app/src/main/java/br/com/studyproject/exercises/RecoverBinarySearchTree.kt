package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

class RecoverBinarySearchTree {
    private var firstNode: TreeNode? = null
    private var secondNode: TreeNode? = null
    private var prevNode: TreeNode? = null

    fun recoverTree(root: TreeNode?) {
        inorderTraversal(root)

        if (firstNode != null && secondNode != null) {
            val temp = firstNode!!.`val`
            firstNode!!.`val` = secondNode!!.`val`
            secondNode!!.`val` = temp
        }
    }

    private fun inorderTraversal(node: TreeNode?) {
        if (node == null) return

        inorderTraversal(node.left)

        if (prevNode != null && prevNode!!.`val` >= node.`val`) {
            if (firstNode == null) {
                firstNode = prevNode
            }
            secondNode = node
        }

        prevNode = node

        inorderTraversal(node.right)
    }
}
