package br.com.studyproject.exercises

fun hIndex(citations: IntArray): Int {
    val sortedCitations = citations.sortedDescending()
    for (i in sortedCitations.indices) {
        if (sortedCitations[i] <= i) {
            return i
        }
    }
    return citations.size
}
