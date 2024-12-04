package br.com.studyproject.exercises

fun isAnagram(s: String, t: String): Boolean {
    if (s.isEmpty() || t.isEmpty() || s.length != t.length) return false

    val anagram = t.toMutableList()

    for (c in s) {
        if (anagram.contains(c)) {
            anagram.remove(c)
        } else {
            return false
        }
    }

    return anagram.isEmpty()
}
