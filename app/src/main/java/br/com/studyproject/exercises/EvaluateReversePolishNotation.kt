package br.com.studyproject.exercises

fun evalRPN(tokens: Array<String>): Int {
    val stack = mutableListOf<Int>()

    for (token in tokens) {
        when (token) {
            "+" -> {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.add(a + b)
            }
            "-" -> {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.add(a - b)
            }
            "*" -> {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.add(a * b)
            }
            "/" -> {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.add(a / b)
            }
            else -> stack.add(token.toInt())
        }
    }

    return stack.last()
}
