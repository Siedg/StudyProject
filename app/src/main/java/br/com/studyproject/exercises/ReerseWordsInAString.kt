package br.com.studyproject.exercises

fun reverseWords(s: String): String {
    val words = s.trim().split("\\s+".toRegex())

    return words.asReversed().joinToString(separator = " ")
}