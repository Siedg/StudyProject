package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
    var current = root

    if (current == null) {
        current = TreeNode(`val`)
        return current
    }

    while (current != null) {
        if (current.`val` > `val`) {
            if (current.left != null) current = current.left
            else {
                current.left = TreeNode(`val`)
                break
            }
        } else {
            if (current.right != null) current = current.right
            else {
                current.right = TreeNode(`val`)
                break
            }
        }
    }

    return root
}
