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
}
