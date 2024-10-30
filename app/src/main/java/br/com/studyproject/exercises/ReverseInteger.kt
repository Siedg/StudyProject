package br.com.studyproject.exercises

class ReverseInteger {
    fun reverse(x: Int): Int {
        var num = x
        var reversed = 0

        while (num != 0) {
            val pop = num % 10
            num /= 10

            if (reversed > Int.MAX_VALUE / 10 || (reversed == Int.MAX_VALUE / 10 && pop > Int.MAX_VALUE % 10)) {
                return 0
            }
            if (reversed < Int.MIN_VALUE / 10 || (reversed == Int.MIN_VALUE / 10 && pop < Int.MIN_VALUE % 10)) {
                return 0
            }

            reversed = reversed * 10 + pop
        }

        return reversed
    }
}