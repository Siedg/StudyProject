package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

class ValidateBinarySearchTree {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root?.left != null) {
            if (root.`val` >= root.left!!.`val`) {
                isValidBST(root.left)
            }
            else return false
        }
        if (root?.right != null) {
            if (root.`val` <= root.right!!.`val`) {
                isValidBST(root.right)
            }
            else return false
        }
        return true
    }

    fun isValidBSTHelper(node: TreeNode?, min: Long, max: Long): Boolean {
        if (node == null) return true
        if (node.`val` <= min || node.`val` >= max) {
            return false
        }
        return isValidBSTHelper(node.left, min, node.`val`.toLong()) &&
                isValidBSTHelper(node.right, node.`val`.toLong(), max)
    }

    fun isValidBSTII(root: TreeNode?): Boolean {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
}
