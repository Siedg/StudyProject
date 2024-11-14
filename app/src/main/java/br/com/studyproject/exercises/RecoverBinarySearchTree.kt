package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

class RecoverBinarySearchTree {
    private var firstNode: TreeNode? = null
    private var secondNode: TreeNode? = null
    private var prevNode = TreeNode(Int.MIN_VALUE)

    fun recoverTree(root: TreeNode?): Unit {
        inOrderTravel(root)

        val temp = firstNode!!.`val`
        firstNode!!.`val` = secondNode!!.`val`
        secondNode!!.`val` = temp
    }

    private fun inOrderTravel(root: TreeNode?) {
        if (root == null) return

        inOrderTravel(root.left)

        if (prevNode.`val` >= root.`val`) {
            if (firstNode == null) {
                firstNode = prevNode
            }
            secondNode = root
        }

        prevNode = root

        inOrderTravel(root.right)
    }
}
