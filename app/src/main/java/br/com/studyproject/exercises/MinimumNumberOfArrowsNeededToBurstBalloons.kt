package br.com.studyproject.exercises

fun findMinArrowShots(points: Array<IntArray>): Int {
    if (points.isEmpty()) return 0

    points.sortBy { it[1] }

    var arrows = 1
    var lastArrowPosition = points[0][1]

    for (i in 1 until points.size) {
        if (points[i][0] > lastArrowPosition) {
            arrows++
            lastArrowPosition = points[i][1]
        }
    }

    return arrows
}
