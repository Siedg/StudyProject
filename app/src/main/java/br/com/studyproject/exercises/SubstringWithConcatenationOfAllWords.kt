package br.com.studyproject.exercises

fun findSubstring(s: String, words: Array<String>): List<Int> {
    if (s.isEmpty() || words.isEmpty()) return listOf()
    val wordFrequency = mutableMapOf<String, Int>()
    val result = mutableListOf<Int>()
    val wordSize = words[0].length
    val totalWords = words.size
    val totalWordLength = wordSize * totalWords

    for (word in words) {
        wordFrequency[word] = wordFrequency.getOrDefault(word, 0) + 1
    }

    for (i in 0 until wordSize) {
        var left = i
        var right = i
        var currentCount = mutableMapOf<String, Int>()
        var count = 0

        while (right + wordSize <= s.length) {
            val word = s.substring(right, right + wordSize)
            right += wordSize

            if (word in wordFrequency) {
                currentCount[word] = currentCount.getOrDefault(word, 0) + 1
                count++

                while (currentCount[word]!! > wordFrequency[word]!!) {
                    val leftWord = s.substring(left, left + wordSize)
                    currentCount[leftWord] = currentCount[leftWord]!! - 1
                    left += wordSize
                    count--
                }

                if (count == totalWords) {
                    result.add(left)
                }
            } else {
                currentCount.clear()
                count = 0
                left = right
            }
        }
    }

    return result
}
