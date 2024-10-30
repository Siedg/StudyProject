package br.com.studyproject.exercises

class ZigzagConversion {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s

        val rows = List(numRows) { StringBuilder() }
        var currRow = 0
        var goingDown = false

        for (c in s) {
            rows[currRow].append(c)

            if (currRow == 0 || currRow == numRows - 1) goingDown = !goingDown
            currRow += if (goingDown) 1 else -1
        }

        val result = StringBuilder()
        for (row in rows) {
            result.append(row)
        }
        return result.toString()
    }
}
