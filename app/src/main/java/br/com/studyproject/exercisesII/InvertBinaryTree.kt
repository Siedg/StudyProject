package br.com.studyproject.exercisesII

import br.com.studyproject.model.TreeNode

/*
Given the root of a binary tree, invert the tree (mirror it).
 */

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null

    val temp = root.left
    root.left = root.right
    root.right = temp

    invertTree(root.left)
    invertTree(root.right)

    return root
}

data class InvertTestCase(
    val input: TreeNode?,
    val expected: TreeNode?
)

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p == null && q == null) return true
    if (p == null || q == null) return false
    if (p.`val` != q.`val`) return false
    return isSameTree(p.left, q.left) &&
            isSameTree(p.right, q.right)
}

fun runInvertTreeTests() {

    val balanced = TreeNode(4,
        TreeNode(2,
            TreeNode(1),
            TreeNode(3)
        ),
        TreeNode(7,
            TreeNode(6),
            TreeNode(9)
        )
    )

    val balancedInverted = TreeNode(4,
        TreeNode(7,
            TreeNode(9),
            TreeNode(6)
        ),
        TreeNode(2,
            TreeNode(3),
            TreeNode(1)
        )
    )

    val leftOnly = TreeNode(1,
        TreeNode(2,
            TreeNode(3),
            null
        ),
        null
    )

    val leftOnlyInverted = TreeNode(1,
        null,
        TreeNode(2,
            null,
            TreeNode(3)
        )
    )

    val negativeTree = TreeNode(-1,
        TreeNode(-2),
        TreeNode(-3)
    )

    val negativeInverted = TreeNode(-1,
        TreeNode(-3),
        TreeNode(-2)
    )

    val testCases = listOf(
        InvertTestCase(null, null),
        InvertTestCase(TreeNode(1), TreeNode(1)),
        InvertTestCase(balanced, balancedInverted),
        InvertTestCase(leftOnly, leftOnlyInverted),
        InvertTestCase(negativeTree, negativeInverted)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = invertTree(test.input)

        if (isSameTree(result, test.expected)) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
