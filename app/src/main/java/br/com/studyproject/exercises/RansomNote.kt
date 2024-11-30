package br.com.studyproject.exercises

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    if (ransomNote.isEmpty() || magazine.isEmpty()) return false
    var mag = magazine
    for (char in ransomNote) {
        if (mag.contains(char)) {
            mag = mag.replaceFirst(char.toString(), "")
        } else {
            return false
        }
    }
    return true
}
