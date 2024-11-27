package br.com.studyproject.exercises

class RandomizedSet() {
    private val map = mutableMapOf<Int, Int>()
    private val list = mutableListOf<Int>()

    fun insert(`val`: Int): Boolean {
        if (map.containsKey(`val`)) return false
        map[`val`] = list.size
        list.add(`val`)
        return true
    }

    fun remove(`val`: Int): Boolean {
        if (!map.containsKey(`val`)) return false
        val index = map[`val`]!!
        val lastElement = list[list.size - 1]
        list[index] = lastElement
        map[lastElement] = index
        list.removeAt(list.size - 1)
        map.remove(`val`)
        return true
    }

    fun getRandom(): Int {
        return list.random()
    }
}
