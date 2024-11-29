package br.com.studyproject.exercises

fun minWindow(s: String, t: String): String {
    if (s.isEmpty() || t.isEmpty()) return ""

    val targetCount = mutableMapOf<Char, Int>()
    for (char in t) {
        targetCount[char] = targetCount.getOrDefault(char, 0) + 1
    }

    val windowCount = mutableMapOf<Char, Int>()
    var left = 0
    var right = 0
    var minLength = Int.MAX_VALUE
    var minWindow = ""
    var matchedChars = 0

    while (right < s.length) {
        val rightChar = s[right]
        windowCount[rightChar] = windowCount.getOrDefault(rightChar, 0) + 1
        if (windowCount[rightChar] == targetCount.getOrDefault(rightChar, 0)) {
            matchedChars++
        }

        while (matchedChars == targetCount.size) {
            if (right - left + 1 < minLength) {
                minLength = right - left + 1
                minWindow = s.substring(left, right + 1)
            }

            val leftChar = s[left]
            windowCount[leftChar] = windowCount[leftChar]!! - 1
            if (windowCount[leftChar]!! < targetCount.getOrDefault(leftChar, 0)) {
                matchedChars--
            }
            left++
        }

        right++
    }

    return minWindow
}
