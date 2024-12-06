package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun flatten(root: TreeNode?) {
    var current = root

    while (current != null) {
        if (current.left != null) {
            var rightmost = current.left
            while (rightmost?.right != null) {
                rightmost = rightmost.right
            }
            rightmost?.right = current.right
            current.right = current.left
            current.left = null
        }
        current = current.right
    }
}
