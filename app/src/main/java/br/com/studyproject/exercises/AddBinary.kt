package br.com.studyproject.exercises

class AddBinary {
    fun addBinary(a: String, b: String): String {
        val sb = StringBuilder()
        var carry = 0
        var i = a.length - 1
        var j = b.length - 1

        while (i >= 0 || j >= 0 || carry > 0) {
            val sum = carry + (if (i >= 0) a[i--] - '0' else 0) + (if (j >= 0) b[j--] - '0' else 0)
            carry = sum / 2
            sb.append(sum % 2)
        }

        return sb.reverse().toString()
    }
}