package br.com.studyproject.exercisesII

/*
Implemente stack usando apenas queue.
 */

import java.util.ArrayDeque

class MyStack() {

    private val queue = ArrayDeque<Int>()

    fun push(x: Int) {
        queue.addLast(x)

        repeat(queue.size - 1) {
            queue.addLast(queue.removeFirst())
        }
    }

    fun pop(): Int {
        return queue.removeFirst()
    }

    fun top(): Int {
        return queue.first()
    }

    fun empty(): Boolean {
        return queue.isEmpty()
    }
}

fun runStackTests() {

    var passed = 0

    fun assert(condition: Boolean, message: String) {
        if (condition) {
            println("$message ✅ PASSED")
            passed++
        } else {
            println("$message ❌ FAILED")
        }
    }

    // Test 1 - Empty on new stack
    val stack1 = MyStack()
    assert(stack1.empty(), "Test 1 - Empty on new stack")

    // Test 2 - Push and top
    stack1.push(1)
    assert(stack1.top() == 1, "Test 2 - Top after single push")

    // Test 3 - Not empty after push
    assert(!stack1.empty(), "Test 3 - Not empty after push")

    // Test 4 - Push multiple and pop LIFO
    stack1.push(2)
    stack1.push(3)
    assert(stack1.pop() == 3, "Test 4 - Pop returns last pushed")

    // Test 5 - Next pop
    assert(stack1.pop() == 2, "Test 5 - Pop second value")

    // Test 6 - Remaining element
    assert(stack1.pop() == 1, "Test 6 - Pop first value")

    // Test 7 - Empty after pops
    assert(stack1.empty(), "Test 7 - Empty after all pops")

    // Test 8 - Interleaved operations
    val stack2 = MyStack()
    stack2.push(10)
    stack2.push(20)
    assert(stack2.pop() == 20, "Test 8 - Interleave pop")
    stack2.push(30)
    assert(stack2.top() == 30, "Test 9 - Top after interleave")
    assert(stack2.pop() == 30, "Test 10 - Pop after interleave")
    assert(stack2.pop() == 10, "Test 11 - Final pop correct")
    assert(stack2.empty(), "Test 12 - Empty after interleave sequence")

    // Test 13 - Large push
    val stack3 = MyStack()
    for (i in 1..1000) {
        stack3.push(i)
    }
    var correct = true
    for (i in 1000 downTo 1) {
        if (stack3.pop() != i) {
            correct = false
            break
        }
    }
    assert(correct, "Test 13 - Large LIFO correctness")
    assert(stack3.empty(), "Test 14 - Empty after large test")

    println("Final Result: $passed tests passed.")
}