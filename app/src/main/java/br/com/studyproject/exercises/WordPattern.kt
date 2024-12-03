package br.com.studyproject.exercises

fun wordPattern(pattern: String, s: String): Boolean {
    val words = s.split(" ")
    if (pattern.length != words.size) return false

    val charToWord = mutableMapOf<Char, String>()
    val wordToChar = mutableMapOf<String, Char>()

    for ((i, char) in pattern.withIndex()) {
        val word = words[i]
        if (charToWord[char]?.let { it != word } == true) return false
        if (wordToChar[word]?.let { it != char } == true) return false
        charToWord[char] = word
        wordToChar[word] = char
    }

    return true
}
