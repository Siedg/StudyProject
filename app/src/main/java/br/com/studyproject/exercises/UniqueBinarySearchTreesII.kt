package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

class UniqueBinarySearchTreesII {
    fun generateTrees(n: Int): List<TreeNode?> {
        if (n == 0) return emptyList()
        return generateTreesInRange(1, n)
    }

    private fun generateTreesInRange(start: Int, end: Int): List<TreeNode?> {
        val trees = mutableListOf<TreeNode?>()

        if (start > end) {
            trees.add(null)
            return trees
        }

        for (i in start..end) {
            val leftTrees = generateTreesInRange(start, i - 1)
            val rightTrees = generateTreesInRange(i + 1, end)

            for (left in leftTrees) {
                for (right in rightTrees) {
                    val root = TreeNode(i)
                    root.left = left
                    root.right = right
                    trees.add(root)
                }
            }
        }

        return trees
    }
}
