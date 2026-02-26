package br.com.studyproject.exercisesII

import br.com.studyproject.model.TreeNode

/*
Given the root of a binary tree, check whether it is a mirror of itself (symmetric around its center).
 */

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) return true
    return isMirror(root.left, root.right)
}

private fun isMirror(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) return true
    if (left == null || right == null) return false
    if (left.`val` != right.`val`) return false

    return isMirror(left.left, right.right) &&
            isMirror(left.right, right.left)
}

data class SymmetricTestCase(
    val root: TreeNode?,
    val expected: Boolean
)

fun runSymmetricTreeTests() {

    val symmetricFull = TreeNode(1,
        TreeNode(2,
            TreeNode(3),
            TreeNode(4)
        ),
        TreeNode(2,
            TreeNode(4),
            TreeNode(3)
        )
    )

    val notSymmetricStructure = TreeNode(1,
        TreeNode(2,
            null,
            TreeNode(3)
        ),
        TreeNode(2,
            null,
            TreeNode(3)
        )
    )

    val notSymmetricValue = TreeNode(1,
        TreeNode(2,
            TreeNode(3),
            null
        ),
        TreeNode(2,
            null,
            TreeNode(4)
        )
    )

    val leftHeavy = TreeNode(1,
        TreeNode(2,
            TreeNode(3),
            null
        ),
        null
    )

    val rightHeavy = TreeNode(1,
        null,
        TreeNode(2,
            null,
            TreeNode(3)
        )
    )

    val negativeSymmetric = TreeNode(-1,
        TreeNode(-2),
        TreeNode(-2)
    )

    val testCases = listOf(
        SymmetricTestCase(null, true),
        SymmetricTestCase(TreeNode(1), true),
        SymmetricTestCase(TreeNode(1, TreeNode(2), TreeNode(2)), true),
        SymmetricTestCase(symmetricFull, true),
        SymmetricTestCase(notSymmetricStructure, false),
        SymmetricTestCase(notSymmetricValue, false),
        SymmetricTestCase(leftHeavy, false),
        SymmetricTestCase(rightHeavy, false),
        SymmetricTestCase(negativeSymmetric, true)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {
        val result = isSymmetric(test.root)

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
