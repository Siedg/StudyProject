package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }

    // Troca os filhos esquerdo e direito
    val temp = root.left
    root.left = root.right
    root.right = temp

    // Recursivamente inverte as subárvores
    invertTree(root.left)
    invertTree(root.right)

    return root
}
