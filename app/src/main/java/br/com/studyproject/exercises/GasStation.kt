package br.com.studyproject.exercises

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var totalTank = 0
    var currentTank = 0
    var startIndex = 0

    for (i in gas.indices) {
        totalTank += gas[i] - cost[i]
        currentTank += gas[i] - cost[i]

        if (currentTank < 0) {
            startIndex = i + 1
            currentTank = 0
        }
    }

    return if (totalTank >= 0) startIndex else -1
}
