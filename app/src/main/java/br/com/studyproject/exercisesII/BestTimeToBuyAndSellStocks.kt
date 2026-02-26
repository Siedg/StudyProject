package br.com.studyproject.exercisesII

import kotlin.math.max

/*
Given an array prices where prices[i] is the price of a stock on day i,
return the maximum profit you can achieve from a single buy and a single sell.
You must buy before you sell.
If no profit is possible, return 0.
 */

fun bestTimeToBuyAndSellStocks(prices: IntArray): Int {
    if (prices.isEmpty()) return 0
    var minPrice = Integer.MAX_VALUE
    var maxProfit = 0

    for (index in prices.indices) {
        if (prices[index] < minPrice) {
            minPrice = prices[index]
        } else if (prices[index] - minPrice > maxProfit) {
            maxProfit = prices[index] - minPrice
        }
    }

    return maxProfit
}

data class StockTestCase(
    val prices: IntArray,
    val expected: Int
)

fun runBestTimeToBuySellTests() {

    val testCases = listOf(
        StockTestCase(intArrayOf(7,1,5,3,6,4), 5),
        StockTestCase(intArrayOf(7,6,4,3,1), 0),
        StockTestCase(intArrayOf(1,2,3,4,5), 4),
        StockTestCase(intArrayOf(5), 0),
        StockTestCase(intArrayOf(), 0),
        StockTestCase(intArrayOf(1,5), 4),
        StockTestCase(intArrayOf(5,1), 0),
        StockTestCase(intArrayOf(3,3,3,3), 0),
        StockTestCase(intArrayOf(9,8,7,1,10), 9),
        StockTestCase(intArrayOf(5,2,6,1,4), 4),
        StockTestCase(intArrayOf(2,4,1), 2),
        StockTestCase(intArrayOf(3,2,1,2,3,4), 3),
        StockTestCase(intArrayOf(1,7,2,8,3,9), 8),
        StockTestCase((1..10000).toList().toIntArray(), 9999),
        StockTestCase((10000 downTo 1).toList().toIntArray(), 0)
    )

    var passed = 0

    for ((index, test) in testCases.withIndex()) {

        val result = bestTimeToBuyAndSellStocks(test.prices)

        if (result == test.expected) {
            println("Test ${index + 1} ✅ PASSED")
            passed++
        } else {
            println("Test ${index + 1} ❌ FAILED")
            println("Prices: ${test.prices.take(10)}...")
            println("Expected: ${test.expected}")
            println("Received: $result")
            println()
        }
    }

    println("Final Result: $passed/${testCases.size} tests passed.")
}
