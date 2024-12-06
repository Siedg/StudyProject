package br.com.studyproject.exercises

fun calculate(s: String): Int {
    val stack = mutableListOf<Int>()
    var currentNumber = 0
    var sign = 1
    var result = 0

    for (char in s) {
        when {
            char.isDigit() -> {
                currentNumber = currentNumber * 10 + (char - '0')
            }
            char == '+' -> {
                result += sign * currentNumber
                currentNumber = 0
                sign = 1
            }
            char == '-' -> {
                result += sign * currentNumber
                currentNumber = 0
                sign = -1
            }
            char == '(' -> {
                stack.add(result)
                stack.add(sign)
                result = 0
                sign = 1
            }
            char == ')' -> {
                result += sign * currentNumber
                currentNumber = 0
                result *= stack.removeLast()
                result += stack.removeLast()
            }
        }
    }
    result += sign * currentNumber
    return result
}
