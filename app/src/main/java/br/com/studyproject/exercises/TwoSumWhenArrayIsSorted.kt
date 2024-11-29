package br.com.studyproject.exercises

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var left = 0
    var right = numbers.lastIndex

    while (left < right) {
        val sum = numbers[left] + numbers[right]

        when {
            sum == target -> return intArrayOf(left + 1, right + 1)
            sum > target -> right--
            sum < target -> left++
        }
    }

    return intArrayOf(-1, -1)
}
