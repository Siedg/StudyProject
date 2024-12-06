package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    val inorderMap = inorder.withIndex().associate { it.value to it.index }

    fun helper(preStart: Int, inStart: Int, inEnd: Int): TreeNode? {
        if (preStart >= preorder.size || inStart > inEnd) return null
        val rootValue = preorder[preStart]
        val root = TreeNode(rootValue)
        val rootIndex = inorderMap[rootValue]!!
        root.left = helper(preStart + 1, inStart, rootIndex - 1)
        root.right = helper(preStart + (rootIndex - inStart + 1), rootIndex + 1, inEnd)
        return root
    }

    return helper(0, 0, inorder.size - 1)
}
