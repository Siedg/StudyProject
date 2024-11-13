package br.com.studyproject.exercises

import br.com.studyproject.model.TreeNode

class BSTIterator {
    class BSTIterator(root: TreeNode?) {
        private val stack = ArrayDeque<TreeNode>()

        init {
            pushLeftPath(root)
        }

        private fun pushLeftPath(node: TreeNode?) {
            var current = node
            while (current != null) {
                stack.addFirst(current)
                current = current.left
            }
        }

        fun next(): Int {
            val node = stack.removeFirst()
            if (node.right != null) {
                pushLeftPath(node.right)
            }
            return node.`val`
        }

        fun hasNext(): Boolean {
            return stack.isNotEmpty()
        }
    }
}
