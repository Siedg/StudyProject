package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

fun sortedArrayToBST(nums: IntArray): TreeNode? {
    if (nums.isEmpty()) return null

    fun helper(start: Int, end: Int): TreeNode? {
        if (start > end) return null

        val mid = start + (end - start) / 2
        val node = TreeNode(nums[mid])

        node.left = helper(start, mid - 1)
        node.right = helper(mid + 1, end)

        return node
    }

    return helper(0, nums.lastIndex)
}
