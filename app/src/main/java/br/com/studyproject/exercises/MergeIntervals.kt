package br.com.studyproject.exercises

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return arrayOf()

    intervals.sortBy { it[0] }

    val result = mutableListOf<IntArray>()
    var currentInterval = intervals[0]
    result.add(currentInterval)

    for (i in 1 until intervals.size) {
        val nextInterval = intervals[i]
        if (currentInterval[1] >= nextInterval[0]) {
            currentInterval[1] = maxOf(currentInterval[1], nextInterval[1])
        } else {
            currentInterval = nextInterval
            result.add(currentInterval)
        }
    }

    return result.toTypedArray()
}
