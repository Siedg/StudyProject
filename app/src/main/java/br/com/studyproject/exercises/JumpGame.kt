package br.com.studyproject.exercises

fun canJump(nums: IntArray): Boolean {
    var farthest = 0

    for (i in nums.indices) {
        if (i > farthest) {
            return false
        }

        farthest = maxOf(farthest, i + nums[i])

        if (farthest >= nums.size - 1) {
            return true
        }
    }

    return false
}

fun jump(nums: IntArray): Int {
    var jumps = 0
    var current_end = 0
    var farthest = 0

    for (i in 0 until nums.size - 1) {
        farthest = maxOf(farthest, i + nums[i])

        if (i == current_end) {
            jumps++
            current_end = farthest
        }
    }

    return jumps
}
