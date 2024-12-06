package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun buildTreeInPos(inorder: IntArray, postorder: IntArray): TreeNode? {
    val inorderMap = inorder.withIndex().associate { it.value to it.index }

    fun helper(postStart: Int, inStart: Int, inEnd: Int): TreeNode? {
        if (postStart < 0 || inStart > inEnd) return null
        val rootValue = postorder[postStart]
        val root = TreeNode(rootValue)
        val rootIndex = inorderMap[rootValue]!!

        root.right = helper(postStart - 1, rootIndex + 1, inEnd)
        root.left = helper(postStart - (inEnd - rootIndex) - 1, inStart, rootIndex - 1)

        return root
    }

    return helper(postorder.size - 1, 0, inorder.size - 1)
}
