package br.com.studyproject.exercises

class LetterCombinationsOfAPhoneNumber {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()

        val digitsMap = mapOf(
            '2' to "abc",
            '3' to "def",
            '4' to "ghi",
            '5' to "jkl",
            '6' to "mno",
            '7' to "pqrs",
            '8' to "tuv",
            '9' to "wxyz"
        )

        val mapToCombine = mutableListOf<String>()

        for (c in digits) {
            if (digitsMap.containsKey(c)) {
                mapToCombine.add(digitsMap[c] ?: "")
            }
        }

        return combineValues(mapToCombine)
    }

    private fun combineValues(lists: List<String>): List<String> {
        val result = mutableListOf<String>()
        combineRecursive(lists, 0, "", result)
        return result
    }

    private fun combineRecursive(lists: List<String>, index: Int, current: String, result: MutableList<String>) {
        if (index == lists.size) {
            if (current.isNotEmpty()) {
                result.add(current)
            }
            return
        }

        for (char in lists[index]) {
            combineRecursive(lists, index + 1, current + char, result)
        }
    }
}
