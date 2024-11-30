package br.com.studyproject.exercises

fun canConstructOn(ransomNote: String, magazine: String): Boolean {
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

fun canConstructOmn(ransomNote: String, magazine: String): Boolean {
    if (ransomNote.isEmpty() || magazine.isEmpty()) return false
    val count = IntArray(26)
    for (char in magazine) {
        count[char - 'a']++
    }
    for (char in ransomNote) {
        if (count[char - 'a'] == 0) return false
        count[char - 'a']--
    }
    return true
}
