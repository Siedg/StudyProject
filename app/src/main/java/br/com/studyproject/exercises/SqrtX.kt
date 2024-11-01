package br.com.studyproject.exercises

class SqrtX {
    fun mySqrt(x: Int): Int {
        if (x < 2) return x

        var left = 2
        var right = x / 2

        while (left <= right) {
            val mid = left + (right - left) / 2
            val midSquared = mid.toLong() * mid

            when {
                midSquared == x.toLong() -> return mid
                midSquared < x.toLong() -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return right
    }
}
