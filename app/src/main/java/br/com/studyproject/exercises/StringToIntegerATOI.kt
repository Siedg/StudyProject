package br.com.studyproject.exercises

class StringToIntegerATOI {
    fun myAtoi(s: String): Int {
        var result = s.trim()
        if (result.isEmpty()) return 0

        var signal = 1
        if (result.first() == '+' || result.first() == '-') {
            signal = if (result.first() == '-') -1 else 1
            result = result.substring(1)
        }

        var number: Long = 0
        for (c in result) {
            if (!c.isDigit()) break
            number = number * 10 + (c - '0')

            if (number * signal > Int.MAX_VALUE) return Int.MAX_VALUE
            if (number * signal < Int.MIN_VALUE) return Int.MIN_VALUE
        }

        return (number * signal).toInt()
    }

}