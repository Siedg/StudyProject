package br.com.studyproject.exercises

fun rotate(nums: IntArray, k: Int): Unit {
    if (nums.isEmpty() || k <= 0) return

    val offset = k % nums.size
    var count = 0
    var start = 0

    while (count < nums.size) {
        var currentPos = start
        var currentElement = nums[start]

        do {
            val nextPos = (currentPos + offset) % nums.size
            val temp = nums[nextPos]
            nums[nextPos] = currentElement
            currentElement = temp
            currentPos = nextPos
            count++
        } while (currentPos != start)

        start++
    }
}
