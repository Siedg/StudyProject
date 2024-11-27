package br.com.studyproject.exercises

class ValidParentheses {
    fun isValid(s: String): Boolean {
        if (s.length % 2 != 0) return false

        val stack = mutableListOf<Char>()
        val matchingPairs = mapOf(')' to '(', ']' to '[', '}' to '{')

        for (char in s) {
            if (char in matchingPairs.values) {
                stack.add(char)
            } else if (char in matchingPairs.keys) {
                if (stack.isEmpty() || stack.removeAt(stack.lastIndex) != matchingPairs[char]) {
                    return false
                }
            }
        }

        return stack.isEmpty()
    }

}
