package br.com.studyproject.exercises

fun isPalindrome(s: String): Boolean {
    val str = s.replace(" ", "").filter { it.isLetterOrDigit() }.lowercase()

    return str == str.reversed()
}
