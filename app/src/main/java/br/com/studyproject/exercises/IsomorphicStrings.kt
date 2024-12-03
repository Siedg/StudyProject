package br.com.studyproject.exercises

fun isIsomorphic(s: String, t: String): Boolean {
    if (s.length != t.length) return false

    val mapST = mutableMapOf<Char, Char>()
    val mapTS = mutableMapOf<Char, Char>()

    for (i in s.indices) {
        val charS = s[i]
        val charT = t[i]

        if (mapST[charS] != null && mapST[charS] != charT) return false
        if (mapTS[charT] != null && mapTS[charT] != charS) return false

        mapST[charS] = charT
        mapTS[charT] = charS
    }

    return true
}
