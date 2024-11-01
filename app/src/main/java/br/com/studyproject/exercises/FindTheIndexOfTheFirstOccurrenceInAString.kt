package br.com.studyproject.exercises

class FindTheIndexOfTheFirstOccurrenceInAString {
    fun strStr(haystack: String, needle: String): Int {
        if (haystack.contains(needle)) {
            val aux = haystack.replaceFirst(needle, "\\")
            return aux.indexOf("\\")
        }
        return -1
    }
}