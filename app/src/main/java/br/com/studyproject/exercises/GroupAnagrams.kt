package br.com.studyproject.exercises

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val anagramMap = mutableMapOf<String, MutableList<String>>()

    for (str in strs) {
        val sortedStr = str.toCharArray().sorted().joinToString("")
        anagramMap.computeIfAbsent(sortedStr) { mutableListOf() }.add(str)
    }

    return anagramMap.values.toList()
}
