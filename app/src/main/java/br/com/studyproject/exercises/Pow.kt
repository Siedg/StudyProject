package br.com.studyproject.exercises

class Pow {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) return 1.0
        if (x == 0.0) return 0.0

        var base = x
        var exponent = n
        var result = 1.0

        if (exponent < 0) {
            base = 1 / base
            exponent = -exponent
        }

        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result *= base
            }
            base *= base
            exponent /= 2
        }

        return result
    }
}
