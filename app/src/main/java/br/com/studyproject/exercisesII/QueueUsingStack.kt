package br.com.studyproject.exercisesII

/*
Implemente queue usando apenas stack.
 */

import java.util.ArrayDeque

class MyQueue() {

    private val inStack = ArrayDeque<Int>()
    private val outStack = ArrayDeque<Int>()

    fun push(x: Int) {
        inStack.addLast(x)
    }

    fun pop(): Int {
        moveIfNeeded()
        return outStack.removeLast()
    }

    fun peek(): Int {
        moveIfNeeded()
        return outStack.last()
    }

    fun empty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }

    private fun moveIfNeeded() {
        if (outStack.isEmpty()) {
            while (inStack.isNotEmpty()) {
                outStack.addLast(inStack.removeLast())
            }
        }
    }
}

fun runQueueTests() {

    var passed = 0

    fun assert(condition: Boolean, message: String) {
        if (condition) {
            println("$message ✅ PASSED")
            passed++
        } else {
            println("$message ❌ FAILED")
        }
    }

    // Test 1 - New queue is empty
    val queue1 = MyQueue()
    assert(queue1.empty(), "Test 1 - Empty on new queue")

    // Test 2 - Push and peek
    queue1.push(1)
    assert(queue1.peek() == 1, "Test 2 - Peek after single push")

    // Test 3 - Not empty after push
    assert(!queue1.empty(), "Test 3 - Not empty after push")

    // Test 4 - FIFO behavior
    queue1.push(2)
    queue1.push(3)
    assert(queue1.pop() == 1, "Test 4 - FIFO first pop")

    // Test 5 - Next pop
    assert(queue1.pop() == 2, "Test 5 - FIFO second pop")

    // Test 6 - Peek does not remove
    assert(queue1.peek() == 3, "Test 6 - Peek does not remove")
    assert(queue1.pop() == 3, "Test 7 - Pop after peek")

    // Test 8 - Empty after all pops
    assert(queue1.empty(), "Test 8 - Empty after pops")

    // Test 9 - Interleaving operations
    val queue2 = MyQueue()
    queue2.push(10)
    queue2.push(20)
    assert(queue2.pop() == 10, "Test 9 - Interleave first pop")
    queue2.push(30)
    assert(queue2.peek() == 20, "Test 10 - Peek after interleave")
    assert(queue2.pop() == 20, "Test 11 - Interleave second pop")
    assert(queue2.pop() == 30, "Test 12 - Interleave third pop")
    assert(queue2.empty(), "Test 13 - Empty after interleave")

    // Test 14 - Large sequence
    val queue3 = MyQueue()
    for (i in 1..1000) {
        queue3.push(i)
    }

    var correct = true
    for (i in 1..1000) {
        if (queue3.pop() != i) {
            correct = false
            break
        }
    }

    assert(correct, "Test 14 - Large FIFO correctness")
    assert(queue3.empty(), "Test 15 - Empty after large sequence")

    println("Final Result: $passed tests passed.")
}
