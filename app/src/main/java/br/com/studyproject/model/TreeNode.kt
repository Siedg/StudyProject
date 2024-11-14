package br.com.studyproject.model

import kotlin.math.abs

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun getBSTHeight(root: TreeNode?): Int {
    if (root == null) return 0

    val leftHeight = getBSTHeight(root.left)
    val rightHeight = getBSTHeight(root.right)

    return leftHeight.coerceAtLeast(rightHeight) + 1
}

fun isTreeBalanced(root: TreeNode?): Pair<Boolean, Int> {
    if (root == null) return Pair(true, 0)

    val left = isTreeBalanced(root.left)
    val right = isTreeBalanced(root.right)

    if (!left.first || !right.first) return Pair(false, -1)

    val diff = abs(left.second - right.second)
    return if (diff > 1) Pair(false, -1) else Pair(true, Math.max(left.second, right.second) + 1)
}
