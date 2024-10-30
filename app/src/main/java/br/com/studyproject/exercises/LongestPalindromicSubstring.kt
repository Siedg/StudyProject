package br.com.studyproject.exercises

class LongestPalindromicSubstring {
    fun longestPalindrome(s: String): String {
        var palindrome = ""

        var i = 0
        var j = 1

        while (j <= s.length) {
            val currPalindrome = s.substring(i, j)
            if (isPalindrome(currPalindrome)) {
                if (palindrome.length < currPalindrome.length) {
                    palindrome = currPalindrome
                }
            }
            j++
            if (j > s.length) {
                i++
                j = i
            }
        }
        return palindrome
    }

    private fun isPalindrome(s: String): Boolean {
        var isPalindrome = true

        var j = s.lastIndex
        var i = 0

        while (i <= j) {
            if (s[i] != s[j]) isPalindrome = false
            i++
            j--
        }
        return isPalindrome
    }

    fun longestPalindromeManacher(s: String): String {
        if (s.isEmpty()) return ""

        val t = "#${s.toCharArray().joinToString("#")}#"
        val p = IntArray(t.length)
        var c = 0
        var r = 0
        var maxLen = 0
        var centerIndex = 0

        for (i in t.indices) {
            val mirror = 2 * c - i

            if (i < r) {
                p[i] = minOf(r - i, p[mirror])
            }

            while (i + p[i] + 1 < t.length && i - p[i] - 1 >= 0 && t[i + p[i] + 1] == t[i - p[i] - 1]) {
                p[i]++
            }

            if (i + p[i] > r) {
                c = i
                r = i + p[i]
            }

            if (p[i] > maxLen) {
                maxLen = p[i]
                centerIndex = i
            }
        }

        val start = (centerIndex - maxLen) / 2
        return s.substring(start, start + maxLen)
    }
}
