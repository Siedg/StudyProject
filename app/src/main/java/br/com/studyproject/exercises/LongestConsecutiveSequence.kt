package br.com.studyproject.exercises

fun longestConsecutive(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    val numSet = nums.toHashSet()
    var longestStreak = 0

    for (num in numSet) {
        if (!numSet.contains(num - 1)) {
            var currentNum = num
            var currentStreak = 1

            while (numSet.contains(currentNum + 1)) {
                currentNum += 1
                currentStreak += 1
            }

            longestStreak = maxOf(longestStreak, currentStreak)
        }
    }

    return longestStreak
}
