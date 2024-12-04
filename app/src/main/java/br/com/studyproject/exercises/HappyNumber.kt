package br.com.studyproject.exercises

fun isHappy(n: Int): Boolean {
    var number = n
    val seenNumbers = mutableSetOf<Int>()

    while (number != 1 && number !in seenNumbers) {
        seenNumbers.add(number)
        var newNumber = 0
        var temp = number
        while (temp > 0) {
            val digit = temp % 10
            newNumber += digit * digit
            temp /= 10
        }
        number = newNumber
    }

    return number == 1
}

