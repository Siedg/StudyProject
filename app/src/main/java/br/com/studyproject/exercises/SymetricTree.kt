package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    return isMirror(root.left, root.right)
}

fun isMirror(t1: TreeNode?, t2: TreeNode?): Boolean {
    if (t1 == null && t2 == null) {
        return true
    }
    if (t1 == null || t2 == null) {
        return false
    }
    return t1.`val` == t2.`val` && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left)
}
