package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) {
        return true
    }
    if (p == null || q == null) {
        return false
    }
    if (p.`val` != q.`val`) {
        return false
    }
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
}
