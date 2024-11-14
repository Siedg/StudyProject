package br.com.studyproject.model
import kotlin.collections.List

class Stack<T> {
    private val stack = mutableListOf<T>()

    fun push(item: T) = stack.add(item)

    fun pop(): T? = if (stack.isNotEmpty()) stack.removeLast() else null

    fun get(): T? = if (stack.isNotEmpty()) stack[stack.lastIndex] else null

    fun getStack(): List<T> = stack.asReversed().toList()
}
