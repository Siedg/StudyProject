package br.com.studyproject.exercises

fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) return true
    if (t.isEmpty()) return false
    val sub = s.toMutableList()

    t.forEach {
        if (sub.isEmpty()) return true
        if (it == sub.first()) sub.removeFirst()
    }

    return sub.isEmpty()
}
