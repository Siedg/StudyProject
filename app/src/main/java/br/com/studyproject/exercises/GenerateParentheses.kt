package br.com.studyproject.exercises

class GenerateParentheses {
    fun generateParenthesis(n: Int): List<String> {
        val result = mutableListOf<String>()
        generateCombinations(result, "", 0, 0, n)
        return result
    }

    private fun generateCombinations(result: MutableList<String>, current: String, open: Int, close: Int, max: Int) {
        if (current.length == max * 2) {
            result.add(current)
            return
        }

        if (open < max) {
            generateCombinations(result, current + "(", open + 1, close, max)
        }
        if (close < open) {
            generateCombinations(result, current + ")", open, close + 1, max)
        }
    }
}
