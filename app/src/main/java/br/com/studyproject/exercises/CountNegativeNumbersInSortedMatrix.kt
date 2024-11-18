package br.com.studyproject.exercises

fun countNegativeNumbersInSortedMatrix(nums: List<List<Int>>): Int {
    if (nums.isEmpty()) return 0

    var row = nums.lastIndex
    var column = 0
    var count = 0
    val maxColums = nums[0].lastIndex

    while (row >= 0 && column < maxColums) {
        if (nums[row][column] >= 0) {
            column++
        } else {
            count += maxColums - column + 1
            row--
        }
    }

    return count
}
