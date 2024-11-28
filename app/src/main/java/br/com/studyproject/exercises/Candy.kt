package br.com.studyproject.exercises

fun candy(ratings: IntArray): Int {
    val candies = MutableList(ratings.size) { 1 }

    for (i in 1..ratings.lastIndex) {
        if (ratings[i - 1] < ratings[i]) {
            candies[i] = candies[i - 1] + 1
        }
    }

    for (i in ratings.lastIndex - 1 downTo 0) {
        if (ratings[i] > ratings[i + 1]) {
            candies[i] = maxOf(candies[i], candies[i + 1] + 1)
        }
    }

    return candies.sum()
}

fun candyWithoutArray(ratings: IntArray): Int {
    val n = ratings.size
    var totalCandies = 0
    var currentCandies = 1

    for (i in 0 until n) {
        if (i > 0 && ratings[i] > ratings[i - 1]) {
            currentCandies++
        } else {
            currentCandies = 1
        }
        totalCandies += currentCandies
    }

    currentCandies = 1
    for (i in n - 2 downTo 0) {
        if (ratings[i] > ratings[i + 1]) {
            currentCandies++
        } else {
            currentCandies = 1
        }
        totalCandies += maxOf(currentCandies - 1, 0)
    }

    return totalCandies
}
