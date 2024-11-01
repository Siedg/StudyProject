package br.com.studyproject.exercises

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        return s.trim().split("\\s+".toRegex()).last().length
    }
}