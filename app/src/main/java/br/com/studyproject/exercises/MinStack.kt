package br.com.studyproject.exercises

class MinStack {
    private val stack = mutableListOf<Int>()
    private val minStack = mutableListOf<Int>()

    fun push(`val`: Int) {
        stack.add(`val`)
        if (minStack.isEmpty() || `val` <= minStack.last()) {
            minStack.add(`val`)
        }
    }

    fun pop() {
        if (stack.isNotEmpty()) {
            if (stack.last() == minStack.last()) {
                minStack.removeAt(minStack.size - 1)
            }
            stack.removeAt(stack.size - 1)
        }
    }

    fun top(): Int {
        if (stack.isNotEmpty()) {
            return stack.last()
        }
        throw NoSuchElementException("Stack is empty")
    }

    fun getMin(): Int {
        if (minStack.isNotEmpty()) {
            return minStack.last()
        }
        throw NoSuchElementException("Stack is empty")
    }
}

