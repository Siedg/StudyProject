package br.com.studyproject.exercises

class Gepetto {
    fun binarySearch(list: List<Int>, element: Int): Boolean {
        if (list.isEmpty()) return false

        var left = 0
        var right = list.lastIndex

        while (left <= right) {
            val mid = left + (right - left) / 2

            when {
                list[mid] > element -> right = mid - 1
                (list[mid] < element) -> left = mid + 1
                list[mid] == element -> return true
            }
        }

        return false
    }

    fun countCharsInArrayWithHashMap(s: String): String? {
        if (s.isEmpty()) return null

        val hashMap: HashMap<Char, Int> = hashMapOf()

        s.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }

        return hashMap.toString()
    }
}
