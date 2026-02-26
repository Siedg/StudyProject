package br.com.studyproject.exercisesII

import br.com.studyproject.model.TreeNode

/*
Given the root of a binary tree, return its maximum depth.

Maximum depth = number of nodes in the longest path from the root node to the farthest.
 */

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    return maxDepth(root.left).coerceAtLeast(maxDepth(root.right)) + 1
}

data class DepthTestCase(
    val root: TreeNode?,
    val expected: Int
)

fun runMaxDepthTests() {

    fun leftSkewed(depth: Int): TreeNode? {
        var root: TreeNode? = null
        for (i in depth downTo 1) {
            root = TreeNode(i, root, null)
        }
        return root
    }

    fun rightSkewed(depth: Int): TreeNode? {
        var root: TreeNode? = null
        for (i in depth downTo 1) {
            root = TreeNode(i, null, root)
        }
        return root
    }

    val balanced = TreeNode(3,
        TreeNode(9),
        TreeNode(20,
            TreeNode(15),
            TreeNode(7)
        )
    )

    val unbalanced = TreeNode(1,
        TreeNode(2,
            TreeNode(3, null, TreeNode(4)),
            null
        ),
        null
    )

    val testCases = listOf(
        DepthTestCase(null, 0),
        DepthTestCase(TreeNode(1), 1),
        DepthTestCase(balanced, 3),
        DepthTestCase(leftSkewed(4), 4),
        DepthTestCase(rightSkewed(4), 4),
        DepthTestCase(unbalanced, 4),
        DepthTestCase(leftSkewed(1000), 1000)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {
        val result = maxDepth(test.root)

        if (result == test.expected) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Expected: ${test.expected}")
            println("Received: $result")
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
