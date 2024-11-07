package br.com.studyproject.exercises

import java.math.BigInteger

class UniqueBinarySearchTrees {
    fun numTrees(n: Int): Int {
        val numerator = factorial(2 * n)
        val denominator = factorial(n + 1).multiply(factorial(n))

        return numerator.divide(denominator).toInt()
    }

    private fun factorial(num: Int): BigInteger {
        var result = BigInteger.ONE
        for (i in 2..num) {
            result = result.multiply(BigInteger.valueOf(i.toLong()))
        }
        return result
    }
}
